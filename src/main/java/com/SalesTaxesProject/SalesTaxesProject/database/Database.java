package com.SalesTaxesProject.SalesTaxesProject.database;

import com.SalesTaxesProject.SalesTaxesProject.model.Cart;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Database {

    private List<Cart> carts;

    @PostConstruct
    public void initDatabase()  {

        Database database = new Database();

        byte[] jsonData = null;
        try {
            jsonData = Files.readAllBytes(Paths.get("src/main/resources/data.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        try {
            database = objectMapper.readValue(jsonData, Database.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.carts = database.getBaskets();
    }

    public List<Cart> getBaskets() {
        return this.carts;
    }

    public Cart getFirstCart() {
        return this.carts.get(0);
    }

    public Cart getSecondCart() {
        return this.carts.get(1);
    }

    public Cart getThirdCart() {
        return this.carts.get(2);
    }
}
