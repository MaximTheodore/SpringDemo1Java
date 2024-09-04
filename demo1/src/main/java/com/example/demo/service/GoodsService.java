package com.example.demo.service;



import com.example.demo.model.GoodsModel;

import java.util.List;


public interface GoodsService {
    public List<GoodsModel> findAllGoods();
    public GoodsModel findGoodsById(int id);
    public GoodsModel addGoods(GoodsModel goodsModel);
    public GoodsModel updateGoods(GoodsModel goodsModel);
    public void deleteGoods(int id);

    public void logicDeleteGoods(int id);
    public void restoreAllDeletedGoods();

    public List<GoodsModel> filterGoods(int filterType);
    public List<GoodsModel> searchGoodsByName(String name);
    public void logicDeleteGoodss(List<Integer> ids);
    public void deleteGoodss(List<Integer> ids);



}
