package com.dheeraj.fantasyfootball.configuration;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreBatchConfiguration {
	@Bean
	public ResourcelessTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean(final ResourcelessTransactionManager transactionManager)
			throws Exception {
		MapJobRepositoryFactoryBean mapJobRepositoryFactory = new MapJobRepositoryFactoryBean(transactionManager);
		mapJobRepositoryFactory.afterPropertiesSet();
		return mapJobRepositoryFactory;
	}

	@Bean
	public JobRepository jobRepository(final MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean) throws Exception {
		return mapJobRepositoryFactoryBean.getObject();
	}

	@Bean
	public JobExplorer jobExplorer(final MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean) {
		return new SimpleJobExplorer(mapJobRepositoryFactoryBean.getJobInstanceDao(),
				mapJobRepositoryFactoryBean.getJobExecutionDao(), mapJobRepositoryFactoryBean.getStepExecutionDao(),
				mapJobRepositoryFactoryBean.getExecutionContextDao());
	}

	@Bean
	public SimpleJobLauncher jobLauncher(final JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}
}
