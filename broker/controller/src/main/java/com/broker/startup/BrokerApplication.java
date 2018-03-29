package com.broker.startup;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource(locations = {"classpath:config/applicationContext-*.xml"})
@EnableTransactionManagement
@ComponentScan(value = {"com.broker"})
@MapperScan("com.broker.dao")
public class BrokerApplication extends SpringBootServletInitializer{

	final Logger logger = Logger.getLogger(BrokerApplication.class);

//	static {
//		PropertyConfigurator.configure(DemoApplication.class.getResource("/").getPath()+"/log4j.properties");
//	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BrokerApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(BrokerApplication.class, args);
	}
}
