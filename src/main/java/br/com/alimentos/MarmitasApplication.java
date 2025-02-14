package br.com.alimentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Vendas De Marmitas.",
				version = "1.0",
				description = " API para um sistema que auxilia profissionais vendedores de marmitas,integrada a api da viacep.",
				contact = @Contact(name = "Carlos Roberto Ribeiro Santos Junior", email = "crrsj1@gmail.com")
		)
)
public class MarmitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarmitasApplication.class, args);
	}

}
