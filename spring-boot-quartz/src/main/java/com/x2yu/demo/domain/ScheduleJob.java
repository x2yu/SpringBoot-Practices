package com.x2yu.demo.domain;



import javax.persistence.*;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:46
 * @Describle:实体需要的基础配置
 */
@Entity
@Table
public class ScheduleJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String JobName;
    private String cronExpression;
    private String springId;
    private String methodName;
    private String jobStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getSpringId() {
        return springId;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
}
