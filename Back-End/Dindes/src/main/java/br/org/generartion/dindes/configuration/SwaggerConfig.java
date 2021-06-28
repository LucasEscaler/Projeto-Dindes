package br.org.generartion.dindes.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.org.generartion.dindes.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessageForGET());
	}

	public static ApiInfo metadata() {
		return new ApiInfoBuilder().title("API - Dindes").description("Projeto API - Dindes")
				.version("1.0.0").license("Apache License Version 2.0").licenseUrl("http://localhost:8080/swagger-ui/")
				.contact(contact()).build();
	}

	private static Contact contact() {
		return new Contact("Alex Avelino, João Nicolete, Lucas Escaler e Vinicius Roberto", "https://github.com/LucasEscaler/Projeto-Dindes.git", "joao.nicolete@usp.br, lucas.escaler@outlook.com, vinicius.rob2002@gmail.com, alourenco08@gmail.com");
	}

	private static List<Response> responseMessageForGET() {
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Deu tudo certo!").build());
				add(new ResponseBuilder().code("201").description("Criado!").build());
				add(new ResponseBuilder().code("401").description("Poxa, não autorizado. Tente novamente.").build());
				add(new ResponseBuilder().code("403").description("Acho que você não pode entrar aqui.").build());
				add(new ResponseBuilder().code("404").description("Não encontramos o que foi pedido, tente novamente.").build());
				add(new ResponseBuilder().code("500").description("Erro, tente de novo.").build());
			}
		};
	}

}
