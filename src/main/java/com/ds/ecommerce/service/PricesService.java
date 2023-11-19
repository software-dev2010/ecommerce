package com.ds.ecommerce.service;

import com.ds.ecommerce.entity.Price;

public interface PricesService {

    Price getPrice(String date, int productId, int brandId);
}
