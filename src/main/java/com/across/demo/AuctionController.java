package com.across.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AuctionController {

	@GetMapping("/auction")
	public String sayHello(@RequestParam(value = "price_floor", defaultValue = "World") String priceFloor,
						   @RequestParam(value = "currency", defaultValue = "USD") String currency) {
		return String.format("%s %s", priceFloor, currency);
	}

}
