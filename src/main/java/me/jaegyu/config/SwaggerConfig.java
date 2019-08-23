package me.jaegyu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@PropertySource("classpath:swagger-v2.properties")
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.groupName("member")
				.select()//
				.apis(RequestHandlerSelectors.any())//
				.paths(Predicates.or(
						PathSelectors.ant("/v1/member-profiles/**")))//
				.build();//
//				.securitySchemes(apiKey())
//				.securityContexts(securityContext());
	}
	
	@Bean
	public Docket api2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("dummy")
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.or(PathSelectors.ant("/v1/dummy/**"),
						PathSelectors.ant("/v1/member-profiles/**")))
				.build();
	}
	
	private List<SecurityContext> securityContext() {
		List<SecurityContext> l = new ArrayList<>();
		l.add(SecurityContext.builder()
		        .securityReferences(defaultAuth())
		        .forPaths(Predicates.or(//
						PathSelectors.ant("/v1/member-profiles/**")))
		        .build());
	    return l;
	  }
	
	private List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	        = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    
	    List<SecurityReference> l = new ArrayList<>();
	    l.add(new SecurityReference("mykey", authorizationScopes));
	    
	    return l;
	  }
	

	private List<ApiKey> apiKey() {
		List<ApiKey> l = new ArrayList<>();
		l.add(new ApiKey("mykey", "api_key", "header"));
	    return l;
	  }
	
	
	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl");
	}
	
//	@Bean
//	  UiConfiguration uiConfig() {
//	    return UiConfigurationBuilder.builder()
//	        .deepLinking(true)
//	        .displayOperationId(false)
//	        .defaultModelsExpandDepth(1)
//	        .defaultModelExpandDepth(1)
//	        .defaultModelRendering(ModelRendering.EXAMPLE)
//	        .displayRequestDuration(false)
//	        .docExpansion(DocExpansion.NONE)
//	        .filter(false)
//	        .maxDisplayedTags(null)
//	        .operationsSorter(OperationsSorter.ALPHA)
//	        .showExtensions(false)
//	        .tagsSorter(TagsSorter.ALPHA)
//	        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//	        .validatorUrl(null)
//	        .build();
//	  }
	
}
