package com.across.demo.app;

import com.across.demo.impl.CurrencyConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AuctionController {

    private CurrencyConverter converter = new CurrencyConverter();

    @GetMapping("/auction")
    public Double defaultAuction(@RequestParam(value = "price_floor", defaultValue = "1") Double priceFloor,
                                 @RequestParam(value = "currency", defaultValue = "EUR") String currency) {
        return converter.convert(priceFloor, currency);
    }

    @GetMapping("/custom-auction")
    public Double cutomizableAuction(@RequestParam(value = "price_floor", defaultValue = "1") Double priceFloor,
                                     @RequestParam(value = "toCurrency", defaultValue = "USD") String toCurrency,
                                     @RequestParam(value = "fromCurrency", defaultValue = "EUR") String fromCurrency) {
        return converter.convert(priceFloor, toCurrency, fromCurrency);
    }
}
