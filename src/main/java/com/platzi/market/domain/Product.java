package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Integer productId;
    private String name;
    private Integer categoryId;
    private Double price;
    private Integer stock;
    private Boolean active;
    private  Category category;

}