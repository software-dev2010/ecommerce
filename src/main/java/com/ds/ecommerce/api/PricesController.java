package com.ds.ecommerce.api;

import com.ds.ecommerce.entity.Price;
import com.ds.ecommerce.map.PriceEntityToResponseMapper;
import com.ds.ecommerce.model.PricesResponse;
import com.ds.ecommerce.service.PricesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class PricesController {

    private final PricesService pricesService;
    private final PriceEntityToResponseMapper mapper;

    @RequestMapping(value="prices", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PricesResponse> getItem(
            @RequestParam("date") @NotEmpty String date,
            @RequestParam("productId") @Positive int productId,
            @RequestParam("brandId") @Positive int brandId) {

        log.info("date = {}, product id = {}, brand id = {}", date, productId, brandId);
        Price price = pricesService.getPrice(date, productId, brandId);

        return ResponseEntity.ok(mapper.fromPriceEntityToResponse(price));
    }
}