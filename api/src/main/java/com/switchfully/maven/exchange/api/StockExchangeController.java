package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stocks")
public class StockExchangeController {

    Logger logger = LoggerFactory.getLogger(StockExchangeController.class);

    private StockService stockService;
    private StockMapper stockMapper;

    @Autowired
    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    /**
     * For your information:
     * This method gets called from outside this application
     * (not really, but just imagine it will)
     */
    @GetMapping("/{stockId}")
    @ResponseBody
    public StockDto getStock(@PathVariable String stockId) {
        logger.trace("I'll update you on every heartbeat 💓");
        logger.debug("I'm taking a (sub)step 🚶");
        logger.info("Business as usual, I processed an action correctly");
        logger.warn("Warning ⚠ I do not trust this situation?!");
        logger.error("Help 🆘 Something is broken!");

        Stock foundStock = stockService.getStock(stockId);
        return stockMapper.mapToDto(foundStock);
    }

}
