package com.currencyexchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.dto.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	@Value("${server.port}")
	private String port;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue value = null;

		if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("INR")) {
			value = new ExchangeValue(1001, from, to, BigDecimal.valueOf(82), port);
		} else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("INR")) {
			value = new ExchangeValue(1002, from, to, BigDecimal.valueOf(90), port);
		}

		return value;
	}

}
