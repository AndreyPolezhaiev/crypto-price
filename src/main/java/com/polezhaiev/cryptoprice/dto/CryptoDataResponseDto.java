package com.polezhaiev.cryptoprice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CryptoDataResponseDto {
    private String symbol;
    private String markPrice;
    private String indexPrice;
    private String estimatedSettlePrice;
    private String lastFundingRate;
    private Long nextFundingTime;
    private String interestRate;
    private Long time;
}
