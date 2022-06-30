package com.mx.mit.bnpl.notificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mx.mit.bnpl.notificacion.config.PropertiesListener;

@SpringBootApplication
public class BnplNotificacionApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BnplNotificacionApplication.class);
		app.addListeners(new PropertiesListener());
		app.run(args);
	}

}
