package com.currencyexchange.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeValue {
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
}
