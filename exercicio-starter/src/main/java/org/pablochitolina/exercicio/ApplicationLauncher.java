package org.pablochitolina.exercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class);
    }
}
