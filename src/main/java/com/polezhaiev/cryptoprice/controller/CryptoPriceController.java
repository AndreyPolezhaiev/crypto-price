package com.polezhaiev.cryptoprice.controller;

import com.polezhaiev.cryptoprice.dto.CryptoDataResponseDto;
import com.polezhaiev.cryptoprice.exception.app.CryptoCurrencyNoValuePresentException;
import com.polezhaiev.cryptoprice.exception.app.CryptocurrencyNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/crypto")
public class CryptoPriceController {
    private static final String BINANCE_API_URL = "https://fapi.binance.com/fapi/v1/premiumIndex";

    @Operation(summary = "Get current price of cryptocurrency",
            description = "Get current price of cryptocurrency")
    @GetMapping("/price")
    public CryptoDataResponseDto getCryptoPrice(@RequestParam String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new CryptoCurrencyNoValuePresentException("Symbol is null or empty");
        }

        String apiUrl = BINANCE_API_URL;
        RestTemplate restTemplate = new RestTemplate();

        apiUrl += "?symbol=" + symbol;

        try {
            CryptoDataResponseDto response = restTemplate.getForObject(
                    apiUrl, CryptoDataResponseDto.class);
            return ResponseEntity.ok(response).getBody();

        } catch (HttpClientErrorException ex) {
            throw new CryptocurrencyNotFoundException("Cryptocurrency " + symbol + " not found");
        }
    }
}
