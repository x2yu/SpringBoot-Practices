package com.x2yu.demo.task;

import com.x2yu.demo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:42
 */

@Component
public class TaskSchedule implements CommandLineRunner {
    @Autowired
    private ITaskService taskService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("任务调度开始==============任务调度开始");
        taskService.timingTask();
        System.out.println("任务调度结束==============任务调度结束");
    }
}
