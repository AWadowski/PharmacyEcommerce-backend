package com.example.code.service;
import com.example.code.Api.TypProduktu;
import com.example.code.model.Product;
import com.example.code.model.ProductRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class CSVReaderService {

    private final ProductRepository productRepository;

    public void readCSV(String filePath) {
        log.info("Rozpoczęto odczyt pliku CSV");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            Long pictureId = 0L;

            while ((nextLine = reader.readNext()) != null) {
                    log.info("Odczytano linię: {}", nextLine);
                    Product product = new Product();
                    product.setPictureId(Long.parseLong(nextLine[0]));
                    product.setName(nextLine[1]);
                    product.setPrice(generateRandomDouble());
                    product.setDescription(nextLine[2]);
                    product.setTyp(getRandomTypProduktu().getDisplayName());
                    product.setIngredients(nextLine[3]);
                    productRepository.save(product);
                    pictureId++;
                    log.info("Zapisano produkt: {}", product);
                }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private static TypProduktu getRandomTypProduktu() {
        Random random = new Random();
        TypProduktu[] typyProduktu = TypProduktu.values();
        return typyProduktu[random.nextInt(typyProduktu.length)];
    }

    private static double generateRandomDouble() {
        Random random = new Random();
        double minValue = 0.0;
        double maxValue = 15.0;
        return minValue + (maxValue - minValue) * random.nextDouble();
    }
}
