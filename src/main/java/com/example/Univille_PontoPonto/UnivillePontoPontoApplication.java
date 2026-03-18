package com.example.Univille_PontoPonto;

import com.example.Univille_PontoPonto.Service.RegistroDePontoDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class UnivillePontoPontoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UnivillePontoPontoApplication.class, args);

        RegistroDePontoDAO rp = new RegistroDePontoDAO(1, java.sql.Date.valueOf("2026-03-17"));
        System.out.println(rp.buscarRegistrosDePonto());

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
