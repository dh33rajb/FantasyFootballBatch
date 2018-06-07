package com.dheeraj.fantasyfootball.application;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.dheeraj.fantasyfootball.domain.model.FantasyFootballResponse;
import com.dheeraj.fantasyfootball.listener.JobCompletionNotificationListener;
import com.dheeraj.fantasyfootball.processor.FantasyFootballBatchProcessor;
import com.dheeraj.fantasyfootball.reader.FantasyFootballApiReader;
import com.dheeraj.fantasyfootball.writer.FantasyFootballDatastoreWriter;

@Configuration
@EnableBatchProcessing
public class FantasyFootballBatchConfiguration extends DefaultBatchConfigurer {

	static final String JOB_NAME = "FantasyFootballStatsJob";

	static final String STEP_NAME = "step1";

	/*
	 * JobRepository, JobLauncher, JobRegistry and PlatformTransactionManager
	 * are already autowired via @EnableBatchProcessing
	 */

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;


	@Bean
	public JobCompletionNotificationListener jobCompletionNotificationListener() {
		return new JobCompletionNotificationListener();
	}

	@Bean
	public Job job(JobCompletionNotificationListener listener, Step step1) {
		return this.jobBuilderFactory.get(JOB_NAME).incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
				.end().build();
	}

	@Bean
	public Step step() {
		return this.stepBuilderFactory.get(STEP_NAME).<FantasyFootballResponse, FantasyFootballResponse>chunk(1)
				.reader(reader()).processor(processor()).writer(writer()).faultTolerant()
				.build();
	}

	@Bean
	public FantasyFootballApiReader reader() {
		return new FantasyFootballApiReader();
	}

	@Bean
	public ItemProcessor<FantasyFootballResponse, FantasyFootballResponse> processor() {
		return new FantasyFootballBatchProcessor();
	}

	@Bean
	public ItemWriter<FantasyFootballResponse> writer() {
		return new FantasyFootballDatastoreWriter();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public void setDataSource(DataSource dataSource) {
		
	}
}
