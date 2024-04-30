package com.polezhaiev.cryptoprice.controller;

import com.polezhaiev.cryptoprice.dto.CryptoDataResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/crypto")
public class CryptoPriceController {
    private static final String BINANCE_API_URL = "https://fapi.binance.com/fapi/v1/premiumIndex";

    @Operation(summary = "Get current price of cryptocurrency",
            description = "Get current price of cryptocurrency")
    @GetMapping("/price")
    public CryptoDataResponseDto getCryptoPrice(@RequestParam String symbol) {
        String apiUrl = BINANCE_API_URL;
        if (symbol != null && !symbol.isEmpty()) {
            apiUrl += "?symbol=" + symbol;
        } else {
            return null;
        }

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiUrl, CryptoDataResponseDto.class);
    }
}
