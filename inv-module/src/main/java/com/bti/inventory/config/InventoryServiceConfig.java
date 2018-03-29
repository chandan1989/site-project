package com.bti.inventory.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryServiceConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
