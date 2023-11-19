package com.ds.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public class PricesResponse {
    @JsonProperty("BRAND_ID")
    private int brandId;
    @JsonProperty("PRODUCT_ID")
    private int productId;
    @JsonProperty("PRICE_LIST")
    private int priceList;
    @JsonProperty("START_DATE")
    private LocalDateTime startDate;
    @JsonProperty("END_DATE")
    private LocalDateTime endDate;
    @JsonProperty("PRICE")
    private double price;
    @JsonProperty("CURR")
    private String currency;
}