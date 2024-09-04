package com.example.demo.service;

import com.example.demo.model.GoodsModel;
import com.example.demo.repository.InMemoryGoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryGoodsServiceImpl implements GoodsService {


    private final InMemoryGoodsRepository goodsRepository;

    public inMemoryGoodsServiceImpl(InMemoryGoodsRepository goodsRepository){
        this.goodsRepository = goodsRepository;
    }
    @Override
    public List<GoodsModel> findAllGoods() {
        return goodsRepository.findAllGoods();
    }

    @Override
    public GoodsModel findGoodsById(int id) {
        return goodsRepository.findGoodsById(id);
    }

    @Override
    public GoodsModel addGoods(GoodsModel goodsModel) {
        return goodsRepository.addGoods(goodsModel);
    }

    @Override
    public GoodsModel updateGoods(GoodsModel goodsModel) {
        return goodsRepository.updateGoods(goodsModel);
    }

    @Override
    public void deleteGoods(int id) {
        goodsRepository.deleteGoods(id);
    }

    @Override
    public void logicDeleteGoods(int id) { goodsRepository.logicDeleteGoods(id);}

    @Override
    public void restoreAllDeletedGoods() { goodsRepository.restoreAllDeletedGoods(); }

    @Override
    public List<GoodsModel> filterGoods(int filterType) {
        return goodsRepository.filterGoods(filterType);
    }

    @Override
    public List<GoodsModel> searchGoodsByName(String name) {
        return goodsRepository.searchGoodsByName(name);
    }

    @Override
    public void logicDeleteGoodss(List<Integer> ids) {
        goodsRepository.logicDeleteGoodss(ids);
    }

    @Override
    public void deleteGoodss(List<Integer> ids) {
        goodsRepository.deleteGoodss(ids);
    }

}
