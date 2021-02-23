package com.halcyon.file_manage.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.halcyon.file_manage.annotations.StartAllJobInit;

@Component
@EnableScheduling
public class TimedTasks {

	protected Logger logger = LoggerFactory.getLogger(TimedTasks.class);

	@Autowired
	private StartAllJobInit job;

	@Scheduled(fixedRate = 120000)
	private void configureTasks() {
		logger.warn("taskJob-REFRSH DB.");
		job.startJob();

	}
}
