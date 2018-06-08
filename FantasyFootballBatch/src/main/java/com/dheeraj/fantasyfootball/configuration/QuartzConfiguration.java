package com.dheeraj.fantasyfootball.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.dheeraj.fantasyfootball.job.QuartzJobLauncher;

@Configuration
public class QuartzConfiguration {

	public static final String JOB_NAME_KEY = "jobName";
	public static final String JOB_LAUNCHER_KEY = "jobLauncher";
	public static final String JOB_LOCATOR_STRING = "jobLocator";

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobLocator jobLocator;

	@Bean
	public JobRegistry jobRegistry() {
		return new MapJobRegistry();
	}

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}

	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(QuartzJobLauncher.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(JOB_NAME_KEY, BatchConfiguration.JOB_NAME);
		map.put(JOB_LAUNCHER_KEY, this.jobLauncher);
		map.put(JOB_LOCATOR_STRING, this.jobLocator);
		jobDetailFactoryBean.setJobDataAsMap(map);
		return jobDetailFactoryBean;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(final JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
		// run everyday at 00:00 hrs
		cronTriggerFactoryBean.setCronExpression("0 0 0 1/1 * ? *");
		return cronTriggerFactoryBean;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(final CronTriggerFactoryBean cronTriggerFactoryBean) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
		return schedulerFactoryBean;
	}
}
