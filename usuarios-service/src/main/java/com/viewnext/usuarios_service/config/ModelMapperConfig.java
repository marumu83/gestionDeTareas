package com.viewnext.usuarios_service.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase para configurar y crear como bean el mapeador de objetos
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Data
@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelmapper() {

        return new ModelMapper();
    }

}