package com.viewnext.gestiontareas.config;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class ModelMapperConfig {

	@Bean
	ModelMapper modelmapper() {
		
		return new ModelMapper();
	}	

}