package org.dwrik.logmonitor;

import org.dwrik.logmonitor.entity.Log;
import org.dwrik.logmonitor.repository.LogmonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LogmonitorApplication implements CommandLineRunner {

	@Autowired
	private LogmonitorRepository logmonitorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LogmonitorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logmonitorRepository.saveAll(List.of(
				new Log(1L, "User login successful"),
				new Log(2L, "Payment processing failed"),
				new Log(3L, "Low stock warning"),
				new Log(4L, "Shipping label generated"),
				new Log(5L, "User password reset requested"),
				new Log(6L, "Database connection failed"),
				new Log(7L, "Email sent successfully"),
				new Log(8L, "Payment gateway response delayed"),
				new Log(9L, "Stock level checked"),
				new Log(10L, "User profile updated")
		));
	}

}
