package com.anu.demo.restwebservice.restwebservicedemo;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

//import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//This is Swagger  configuration file

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Anupam", "www.anupam.com", "anupamsharnagat@gmail.com");
	public static final ApiInfo DEFULT_API_INFO = new ApiInfo("Anupam Api Documentation", "Anupam Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFULT_PRODUCE_AND_CONSUME = new HashSet<String>(java.util.Arrays.asList("application/json","application/xml"));
	//private static final ApiInfo DEFULT_API_INFO = null;

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFULT_API_INFO).produces(DEFULT_PRODUCE_AND_CONSUME).consumes(DEFULT_PRODUCE_AND_CONSUME);
	}

}
