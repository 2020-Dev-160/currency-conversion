package com.in28minute.microservice.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")

//without zuul-api-gateway
//@FeignClient(name="currency-exchange-service")

//with zuul-api-gateway
@FeignClient(name="netflix-zuul-zpi-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//without zuul-api-gateway
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	//with zuul-api-gateway
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
	 
}
