package com.switchfully.maven.exchange.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestApplication.class})
class StockExchangeControllerIntegrationTest {

    @Autowired
    private StockExchangeController controller;

    // Give AA as stockId to the controller and return
    // {"id":"AA","name":"Ambro AN","price":16.589398709812257948215119540691375732421875,"currency":"Euro"}

    @Test
    void getFromController() {
        // GIVEN
        StockDto stock = controller.getStock("AA");
        // WHEN
        // THEN
        Assertions.assertEquals("Ambro AN", stock.getName());
    }

}