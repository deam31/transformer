/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer;

import com.aequilibrium.transformer.builders.TransformerDTOBuilder;
import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.service.TransformerService;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiListingReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class TransformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformerApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(TransformerService transformerService) {
		ApplicationRunner applicationRunner = args -> transformerService.saveAll(getInitTransformers());
		return applicationRunner;
	}

	@Bean
	public Docket transformerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.aequilibrium.transformer.rest"))
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Backend Developer Technical Test")
				.description("Aequilibrium does love transforming.")
				.version("v0.0.1-SNAPSHOT")
				.build();
	}

	private List<TransformerDTO> getInitTransformers() {
		return Arrays.asList(
				TransformerDTOBuilder.builder()
						.withName("Predaking")
						.withCourage(9)
						.withEndurance(6)
						.withRank(9)
						.withFirePower(6)
						.withSpeed(2)
						.withStrength(9)
						.withIntelligence(9)
						.withSkill(10)
						.withType(TransformerType.DECEPTICON)
						.build()

				,TransformerDTOBuilder.builder()
						.withName("Optimus Prime")
						.withCourage(2)
						.withEndurance(9)
						.withFirePower(9)
						.withSpeed(7)
						.withStrength(6)
						.withIntelligence(6)
						.withRank(9)
						.withSkill(7)
						.withType(TransformerType.AUTOBOT)
						.build()

				,TransformerDTOBuilder.builder()
						.withName("Bumblebee")
						.withCourage(4)
						.withEndurance(4)
						.withRank(4)
						.withFirePower(4)
						.withSpeed(4)
						.withStrength(4)
						.withIntelligence(4)
						.withSkill(4)
						.withType(TransformerType.AUTOBOT)
						.build()

				,TransformerDTOBuilder.builder()
						.withName("Soundwave")
						.withCourage(10)
						.withEndurance(9)
						.withRank(2)
						.withFirePower(9)
						.withSpeed(9)
						.withStrength(9)
						.withIntelligence(9)
						.withType(TransformerType.DECEPTICON)
						.build()

				,TransformerDTOBuilder.builder()
						.withName("Shockwave")
						.withCourage(9)
						.withEndurance(10)
						.withRank(3)
						.withFirePower(2)
						.withSpeed(8)
						.withStrength(7)
						.withIntelligence(4)
						.withType(TransformerType.DECEPTICON)
						.build()

				,TransformerDTOBuilder.builder()
						.withName("Skywarp")
						.withCourage(8)
						.withEndurance(3)
						.withRank(1)
						.withFirePower(4)
						.withSpeed(6)
						.withStrength(5)
						.withIntelligence(4)
						.withType(TransformerType.DECEPTICON)
						.build()


		);
	}
}
