package com.dheeraj.fantasyfootball.job;

import java.util.Date;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.dheeraj.fantasyfootball.configuration.QuartzConfiguration;

public class QuartzJobLauncher extends QuartzJobBean {

	public QuartzJobLauncher() {
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello Quartz! - " + new Date());

		Map<String, Object> jobDataMap = context.getMergedJobDataMap();
		String jobName = (String) jobDataMap.get(QuartzConfiguration.JOB_NAME_KEY);
		JobLauncher jobLauncher = (JobLauncher) jobDataMap.get(QuartzConfiguration.JOB_LAUNCHER_KEY);
		JobLocator jobLocator = (JobLocator) jobDataMap.get(QuartzConfiguration.JOB_LOCATOR_STRING);

		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		try {
			Job job = jobLocator.getJob(jobName);
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException | NoSuchJobException e) {
			e.printStackTrace();
		}
	}
}
