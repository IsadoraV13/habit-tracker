package com.isadora.habittracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
// exclude = {DataSourceAutoConfiguration.class}, JpaRepositoriesAutoConfiguration.class
//@ComponentScan(basePackages = {"com.isadora.habittracker.repository", "com.isadora.habittracker.service"})
//@EnableJpaRepositories(basePackageClasses = {HabitRepository.class, RewardRepository.class})
//@EntityScan(basePackages = {"com.isadora.habittracker"})
public class HabitTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitTrackerApplication.class, args);
		System.out.println("this application is running");
	}

}
