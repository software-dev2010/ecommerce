package com.ds.ecommerce.service.impl;

import com.ds.ecommerce.entity.Price;
import com.ds.ecommerce.exception.PriceNotFoundException;
import com.ds.ecommerce.repository.PricesRepository;
import com.ds.ecommerce.service.PricesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;
    @Override
    @Transactional(readOnly = true)
    public Price getPrice(String date, int productId, int brandId) {
        List<Price> prices = pricesRepository.findAllPricesInAPeriod(
                brandId, productId, convertStringToLocalDateTime(date));

        log.info("Price list from db = {}", prices);

        Price price = prices.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("Prices not found"));

        log.info("Price with high priority = {}", price);

        return price;
    }

    private LocalDateTime convertStringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return LocalDateTime.parse(date, formatter);
    }
}