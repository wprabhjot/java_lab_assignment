package com.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyconversion.dto.CurrencyConversion;
import com.currencyconversion.proxies.CurrencyExchangeProxy;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {

	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		var response = currencyExchangeProxy.retrieveExchangeValue(from, to);

		BigDecimal total = quantity.multiply(response.conversionMultiple);

		return new CurrencyConversion(response.id, from, to, quantity, response.conversionMultiple, total,
				response.environment + " via Feign");
	}
}