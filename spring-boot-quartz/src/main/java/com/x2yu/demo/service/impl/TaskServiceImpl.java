package com.x2yu.demo.service.impl;

import com.x2yu.demo.domain.ScheduleJob;
import com.x2yu.demo.repository.ScheduleJobRepository;
import com.x2yu.demo.service.ITaskService;
import com.x2yu.demo.task.QuartzFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:43
 */

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private ScheduleJobRepository scheduleJobRepository;

    @Override
    public void timingTask() {
        //查询数据库是否存在需要定时的任务
        List<ScheduleJob> scheduleJobs = scheduleJobRepository.findAllByJobStatus("1");
        if (scheduleJobs != null) {
            scheduleJobs.forEach(this::execute);
        }
    }

    //添加任务
    private void execute(ScheduleJob scheduleJob){
        try {
            //声明调度器
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            //添加触发调度名称
            TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName());
            //设置触发时间
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
            //触发建立
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            //添加作业名称
            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName());
            //建立作业
            JobDetail jobDetail = JobBuilder.newJob(QuartzFactory.class).withIdentity(jobKey).build();
            //传入调度的数据，在QuartzFactory中需要使用
            jobDetail.getJobDataMap().put("scheduleJob",scheduleJob);
            //调度作业
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
