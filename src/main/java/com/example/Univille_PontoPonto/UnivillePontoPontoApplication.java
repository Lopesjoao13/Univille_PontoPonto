package com.example.Univille_PontoPonto;

import com.example.Univille_PontoPonto.ServiceDAO.FuncionarioDao;
import com.example.Univille_PontoPonto.ServiceDAO.RegistroDePontoDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnivillePontoPontoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UnivillePontoPontoApplication.class, args);

		FuncionarioDao f = new FuncionarioDao();
		f.exibirFuncionarios();

		RegistroDePontoDAO rp = new RegistroDePontoDAO(1, java.sql.Date.valueOf("2026-03-17"));
		System.out.println(rp.buscarRegistrosDePonto());


	}

	@Override
	public void run(String... args) throws Exception {

	}
}
