package com.example.demo.entity;

import com.example.demo.model.GoodsModel;

public class GoodsEntity extends GoodsModel {
    public GoodsEntity(int id, String name, double price, boolean product, boolean isDeleted) {
        super(id, name, price, product, isDeleted);
    }
}
