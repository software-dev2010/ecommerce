package com.ds.ecommerce.map;

import com.ds.ecommerce.entity.Price;
import com.ds.ecommerce.model.PricesResponse;
import org.springframework.stereotype.Component;
@Component
public class PriceEntityToResponseMapper {
    public PricesResponse fromPriceEntityToResponse(Price price) {
        return PricesResponse.builder()
                .brandId(price.getListProductId().getBrandId())
                .productId(price.getListProductId().getProductId())
                .priceList(price.getListProductId().getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .currency(price.getCurrency())
                .build();
    }
}