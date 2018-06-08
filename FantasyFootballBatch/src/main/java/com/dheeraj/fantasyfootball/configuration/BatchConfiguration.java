package com.dheeraj.fantasyfootball.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dheeraj.fantasyfootball.listener.JobCompletionNotificationListener;
import com.dheeraj.fantasyfootball.model.FantasyFootballResponse;
import com.dheeraj.fantasyfootball.processor.FantasyFootballBatchProcessor;
import com.dheeraj.fantasyfootball.reader.FantasyFootballApiReader;
import com.dheeraj.fantasyfootball.writer.FantasyFootballDatastoreWriter;

/**
 * Batch job configuration class.
 */
@Configuration
@EnableBatchProcessing
@Import({ DataSourceConfiguration.class, RestConfiguration.class, CoreBatchConfiguration.class, QuartzConfiguration.class })
public class BatchConfiguration {

	public static final String JOB_NAME = "FantasyFootballStatsJob";

	static final String STEP_NAME = "step1";

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
	public Step step(@Qualifier("mysqlDataSource") final DataSource dataSource) {
		return this.stepBuilderFactory.get(STEP_NAME).<FantasyFootballResponse, FantasyFootballResponse>chunk(1)
				.reader(reader()).processor(processor()).writer(writer(dataSource)).faultTolerant().build();
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
	public ItemWriter<FantasyFootballResponse> writer(@Qualifier("mysqlDataSource") final DataSource dataSource) {
		return new FantasyFootballDatastoreWriter();
	}
}
