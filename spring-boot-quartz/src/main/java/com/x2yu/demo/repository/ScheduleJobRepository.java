package com.x2yu.demo.repository;

import com.x2yu.demo.domain.ScheduleJob;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:47
 */
public interface ScheduleJobRepository extends BaseRepository<ScheduleJob,Long>{
    List<ScheduleJob> findAllByJobStatus(String jobStatus);
}
