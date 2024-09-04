package com.example.demo.repository;


import com.example.demo.model.GoodsModel;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryGoodsRepository {

    private final List<GoodsModel> GOODS = new ArrayList<>();

    private AtomicInteger idCounter = new AtomicInteger(1);

    public GoodsModel addGoods(GoodsModel goodsModel){
        goodsModel.setID(idCounter.getAndIncrement());
        GOODS.add(goodsModel);
        return goodsModel;
    }
    public GoodsModel updateGoods(GoodsModel goodsModel){
        int goodsIndex = IntStream.range(0, GOODS.size())
                .filter(index -> GOODS.get(index).getID() == goodsModel.getID())
                .findFirst()
                .orElse(-1);

        return goodsIndex == -1 ? null : GOODS.set(goodsIndex, goodsModel);
    }

    public List<GoodsModel> findAllGoods() {
        return GOODS.stream().filter(goodsModel -> !goodsModel.isDeleted())
                .collect(Collectors.toList());
    }
    public GoodsModel findGoodsById(int id){
        return GOODS.stream()
                .filter(goodsModel -> goodsModel.getID() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteGoods(int id){
        var goodsModel = findGoodsById(id);
        if (goodsModel != null) {
            GOODS.remove(goodsModel);
        }
    }
    public void logicDeleteGoods(int id){
        var goodsModel = findGoodsById(id);
        if (goodsModel != null) {
            goodsModel.setDeleted(true);
        }
    }
    public void restoreAllDeletedGoods(){
        GOODS.stream()
                .filter(GoodsModel::isDeleted)
                .forEach(goodsModel -> goodsModel.setDeleted(false));
    }

    public void deleteGoodss(List<Integer> ids) {
        GOODS.removeIf(goodsModel -> ids.contains(goodsModel.getID()));
    }

    //множественное логич удаление
    public void logicDeleteGoodss(List<Integer> ids) {
        GOODS.stream()
                .filter(goodsModel -> ids.contains(goodsModel.getID()))
                .forEach(goodsModel -> goodsModel.setDeleted(true));
    }

    public List<GoodsModel> searchGoodsByName(String name) {
        return GOODS.stream()
                .filter(goodsModel -> !goodsModel.isDeleted() && goodsModel.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<GoodsModel> filterGoods(int filterType) {
        return GOODS.stream()
                .filter(goodsModel -> !goodsModel.isDeleted())
                .filter(goodsModel -> {
                    if (filterType == 1) {
                        return goodsModel.getPrice() >= 10;
                    } else if (filterType == 2) {
                        return goodsModel.getName().startsWith("А") || goodsModel.getName().startsWith("A");
                    } else if (filterType == 3) {
                        return goodsModel.getPrice() <= 118;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }



}
