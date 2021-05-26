package com.across.demo.app;

import com.across.demo.impl.CurrencyConverter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class AuctionController {

    private CurrencyConverter converter = new CurrencyConverter();

    @GetMapping("/auction")
    public Double defaultAuction(@RequestParam(value = "price_floor", defaultValue = "1") @Valid Double priceFloor,
                                 @RequestParam(value = "currency", defaultValue = "EUR") @Valid String currency) throws JSONException, IOException, InterruptedException {
        return converter.convert(priceFloor, currency);
    }

    @GetMapping("/custom-auction")
    public Double cutomizableAuction(@RequestParam(value = "price_floor", defaultValue = "1") @Valid Double priceFloor,
                                     @RequestParam(value = "toCurrency", defaultValue = "USD") @Valid String toCurrency,
                                     @RequestParam(value = "fromCurrency", defaultValue = "EUR") @Valid String fromCurrency) throws JSONException, IOException, InterruptedException {
        return converter.convert(priceFloor, toCurrency, fromCurrency);
    }
}
