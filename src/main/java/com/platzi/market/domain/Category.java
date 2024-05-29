package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
    private int categoryId;
    private String category;
    private boolean active;

}
