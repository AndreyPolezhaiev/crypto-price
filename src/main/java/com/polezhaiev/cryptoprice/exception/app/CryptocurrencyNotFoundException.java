package com.polezhaiev.cryptoprice.exception.app;

public class CryptocurrencyNotFoundException extends RuntimeException {
    public CryptocurrencyNotFoundException(String message) {
        super(message);
    }
}
