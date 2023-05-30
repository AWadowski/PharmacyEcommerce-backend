package com.example.code;

import com.example.code.model.Product;
import com.example.code.service.CSVReaderService;
import com.example.code.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class AptekaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AptekaApplication.class, args);

//        CSVReaderService csvReaderService = context.getBean(CSVReaderService.class);
//        csvReaderService.readCSV("bazalekow.csv");
    }

}
