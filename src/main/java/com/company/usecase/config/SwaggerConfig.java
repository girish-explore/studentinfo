package com.company.usecase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//this disables the swagger in prod profile
@Profile("{!prod}")
@Configuration
@EnableSwagger2
public class SwaggerConfig {


}
