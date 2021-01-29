package com.halcyon.file_manage.task;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.halcyon.file_manage.annotations.StartAllJobInit;

@Component
@EnableScheduling // 开始执行定时任务，
public class TimedTasks {

	protected Logger logger = LoggerFactory.getLogger(TimedTasks.class);

	@Autowired
	private StartAllJobInit job;

	/**
	 * （4）0 0 1,12,18 * * ? 每天上午1点，12点，18点
	 * 
	 * （6）0 0 12 ? * WED 表示每个星期三中午12点 （7）0 0 12 * * ? 每天中午12点触发
	 */

	// 添加定时任务
	// 每秒递增运行 0,5,10,15
//	  	 	@Scheduled(cron = "0/60 * * * * ?") //@Scheduled注解 表示此方法是一个定时任务方法
	// 或直接指定时间间隔，例如：5秒
	@Scheduled(fixedRate = 120000)
	private void configureTasks() {
//	       		System.err.println("正在执行定时任务，执行时间: " + LocalDateTime.now());
		logger.warn("taskJob-REFRSH DB.");

		job.startJob();

	}
}
