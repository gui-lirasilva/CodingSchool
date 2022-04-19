package br.com.coddingSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableCaching
@SpringBootApplication
public class CoddingSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoddingSchoolApplication.class, args);
	}

}
