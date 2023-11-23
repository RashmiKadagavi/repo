package com.example.techtestspring;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info =
				@Info(
						title = "Spring Project",
						version = "0.0.1",
						extensions = {
								@Extension(
										properties =
												@ExtensionProperty(
														name = "test-documtent-id",
														value = "1123456"
												)
								)
						}
				)
)
public class TechtestspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechtestspringApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
