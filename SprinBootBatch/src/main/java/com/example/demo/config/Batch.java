package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.listener.JobExecutionListenerImpl;
import com.example.demo.processer.ArrayProcesser;
import com.example.demo.reader.ArrayReader;
import com.example.demo.writter.ArrayWritter;

@Configuration
public class Batch {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Bean
	public Job footballJob() {
		return new JobBuilder("jobA", jobRepository)
				    .listener(ex())
					.start(stepA())
					.next(stepA())
					.build();
	}
	@Bean
	public Step stepA() {
		return new StepBuilder("stepA", jobRepository)
				.<String, String>chunk(2, transactionManager)
				.reader(new ArrayReader())
				.processor(new ArrayProcesser())
				.writer(new ArrayWritter())
				.build();
	}
	
	@Bean
	public JobExecutionListener ex() {
		return new JobExecutionListenerImpl();
	}
	
	
	

}
