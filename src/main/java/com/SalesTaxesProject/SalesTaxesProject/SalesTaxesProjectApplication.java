package com.SalesTaxesProject.SalesTaxesProject;

import com.SalesTaxesProject.SalesTaxesProject.service.MenuSelectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SalesTaxesProjectApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SalesTaxesProjectApplication.class, args);
        MenuSelectorService.loadingMenuSelector();
    }

}
