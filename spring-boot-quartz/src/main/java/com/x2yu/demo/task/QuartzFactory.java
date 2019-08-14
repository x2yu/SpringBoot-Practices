package com.x2yu.demo.task;

import com.x2yu.demo.domain.ScheduleJob;
import com.x2yu.demo.util.SpringUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.lang.reflect.Method;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:43
 * @Describle：任务的调度工厂（主要是实现具体的执行
 */
public class QuartzFactory implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取数据调度
        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");

        //获取对应的bean service
        Object object = SpringUtil.getBean(scheduleJob.getSpringId());

        try{
            //利用反射执行相应方法
            Method method = object.getClass().getMethod(scheduleJob.getMethodName());
            method.invoke(object);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
