package com.example.product.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Docket docket() {
        ParameterBuilder paramBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        params.add(paramBuilder.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .globalOperationParameters(params)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.product"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(List.of("application/json")))
                .produces(new HashSet<String>(List.of("application/json")));

        return docket;
    }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Product API");
        apiInfoBuilder.description("Product API Controller");
        apiInfoBuilder.version("1.0");

        return apiInfoBuilder;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
