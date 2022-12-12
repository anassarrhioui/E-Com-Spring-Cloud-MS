package me.arrhioui.customerservice;

import me.arrhioui.customerservice.entity.Customer;
import me.arrhioui.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(
					List.of(
							new Customer(null, "Anass Arrhioui", "anassarrhioui@gmail.com"),
							new Customer(null, "Ahmed Arrhioui", "ahmedarrhioui@gmail.com"),
							new Customer(null, "Med Arrhioui", "medarrhioui@gmail.com")
					)
			);

			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
