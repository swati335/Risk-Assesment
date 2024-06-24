package com.example.Risk;

import com.example.Risk.model.Risk;
import com.example.Risk.repository.RiskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(RiskRepository riskRepository) {
		return args -> {
			riskRepository.save(new Risk(1L, "Risk 1", "Operational", "High", "Active", "Mitigation Plan 1"));
			riskRepository.save(new Risk(2L, "Risk 2", "Financial", "Medium", "Active", "Mitigation Plan 2"));
		};
	}
}
