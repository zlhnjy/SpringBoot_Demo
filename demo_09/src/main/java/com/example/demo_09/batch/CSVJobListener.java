package com.example.demo_09.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @Auther: zhangliang
 * @Date: 2019/1/18 16:20
 * @Description:
 */
public class CSVJobListener implements JobExecutionListener {

    private Long startTime;
    private Long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("start job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("end job");
        System.out.println("spend " + (endTime - startTime) + "s");
    }
}
