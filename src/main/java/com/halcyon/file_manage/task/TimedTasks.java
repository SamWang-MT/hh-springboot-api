package com.halcyon.file_manage.task;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling //开始执行定时任务，
	   public class TimedTasks {
	  	 	//添加定时任务
	  	 	//每秒递增运行    0,5,10,15
	  	 	@Scheduled(cron = "0/5 * * * * ?") //@Scheduled注解 表示此方法是一个定时任务方法
	   		//或直接指定时间间隔，例如：5秒
	   		//@Scheduled(fixedRate=5000)
	   		private void configureTasks() {
	       		System.err.println("正在执行定时任务，执行时间: " + LocalDateTime.now());
	   }
	}
