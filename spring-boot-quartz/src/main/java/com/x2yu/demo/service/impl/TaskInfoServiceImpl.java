package com.x2yu.demo.service.impl;

import com.x2yu.demo.service.ITaskInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:43
 */

@Service("taskInfo")
@Transactional
public class TaskInfoServiceImpl implements ITaskInfoService {
    @Override
    public void execute() {
        System.out.println("任务执行开始===============任务执行开始");
        System.out.println("测试任务："+new Date());
        System.out.println("任务执行结束===============任务执行结束");
    }
}
