package com.broker.app.startup;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;

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

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置文件大小限制 ,超出设置页面会抛出异常信息，
		// 这样在文件上传的地方就需要进行异常信息的处理了;
		factory.setMaxFileSize("256KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("512KB");
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BrokerApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(BrokerApplication.class, args);
	}
}
