package com.switchfully.maven.exchange.service;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.domain.StockCurrency;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static com.switchfully.maven.exchange.domain.StockCurrency.EUR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class StockServiceTest {

    /**
     * We can't mock the ExternalStockInformationService or StockRepository since no Constructor Dependency Injection
     * is used for the StockService (and both offer a static method to use).
     * Therefore, if the ExternalStockInformationService is broken, these tests might fail.
     *
     * This test can be described as an integration test, rather than a unit test,
     * since it is not only testing the StockService but also the integration
     * with the ExternalStockInformationService en StockRepository
     */

    @Test
    public void getStock_givenAExistingStockId_thenReturnStockEnrichedWithPrice() {
        // GIVEN
        StockService stockService = new StockService();

        // WHEN
        Stock actualStock = stockService.getStock("AA");

        // THEN
        assertThat(actualStock.getId()).isEqualTo("AA");
        assertThat(actualStock.getName()).isEqualTo("Ambro AN");
        assertThat(actualStock.getPrice()).isNotNull();
        assertThat(actualStock.getPrice().getCurrency()).isEqualTo(EUR);
        assertThat(actualStock.getPrice().getPrice()).isBetween(new BigDecimal(10), new BigDecimal(100));
    }

    @Test
    public void getStock_givenAUnknownStockId_thenReturnStockWithUnknownNameAndNoPrice() {
        // GIVEN
        StockService stockService = new StockService();

        // WHEN
        Stock actualStock = stockService.getStock("XXX");

        // THEN
        assertThat(actualStock.getId()).isEqualTo("XXX");
        assertThat(actualStock.getName()).isEqualTo("Unknown stock");
        assertThat(actualStock.getPrice()).isNull();
    }

}