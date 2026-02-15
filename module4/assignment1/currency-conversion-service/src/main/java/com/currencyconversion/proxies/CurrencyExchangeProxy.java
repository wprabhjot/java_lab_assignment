package com.currencyconversion.proxies;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

	class ExchangeValue {
		public int id;
		public String from;
		public String to;
		public BigDecimal conversionMultiple;
		public String environment;
	}
}