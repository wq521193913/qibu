package com.broker.startup;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ImportResource(locations = {"classpath:config/application-*.xml"})
@ComponentScan(value = {"com.broker"})
@MapperScan("com.broker.dao")
public class BrokerApplication {

	final Logger logger = Logger.getLogger(BrokerApplication.class);

//	static {
//		PropertyConfigurator.configure(DemoApplication.class.getResource("/").getPath()+"/log4j.properties");
//	}

	public static void main(String[] args) {

		SpringApplication.run(BrokerApplication.class, args);
	}
}
