/*
package com.my.datastrcture.interview.nextthik;

import lombok.Value;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    public SoldProductsAggregator(EURExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public SoldProductsAggregate aggregate(Stream<SoldProduct> soldProductStream) {
        List<SimpleSoldProduct> products = soldProductStream
                .filter(this::isValidSoldProduct)
                .map(this::convertToEuro)
                .collect(Collectors.toList());

        BigDecimal total = products.stream()
                .map(SimpleSoldProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new SoldProductsAggregate(products, total);
    }

    private boolean isValidSoldProduct(SoldProduct product) {
        return product.getPrice().compareTo(BigDecimal.ZERO) > 0;
    }

    private SimpleSoldProduct convertToEuro(SoldProduct product) {
        BigDecimal euroPrice = exchangeService.rate(product.getCurrency())
                .orElse(BigDecimal.ZERO)
                .multiply(product.getPrice());

        return new SimpleSoldProduct(product.getName(), euroPrice);
    }

    @Value
    public static class SoldProduct {
        String name;
        BigDecimal price;
        String currency;
    }

    @Value
    public static class SimpleSoldProduct {
        String name;
        BigDecimal price;
    }

    @Value
    public static class SoldProductsAggregate {
        List<SimpleSoldProduct> products;
        BigDecimal total;
    }

    public interface EURExchangeService {
        Optional<BigDecimal> rate(String currency);
    }
}
*/
