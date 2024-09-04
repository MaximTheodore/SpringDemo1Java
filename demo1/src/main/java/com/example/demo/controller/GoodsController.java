package com.example.demo.controller;



import com.example.demo.model.GoodsModel;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public String getAllGoods(Model model) {
        model.addAttribute("goods", goodsService.findAllGoods());
        return "GoodsList";
    }

    @PostMapping("/goods/add")
    public String addGoods(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam boolean product,
                            @RequestParam(defaultValue = "false")  boolean isDeleted) {
        GoodsModel newGoods = new GoodsModel(0, name,price, product, isDeleted);
        goodsService.addGoods(newGoods);
        return "redirect:/goods";
    }

    @PostMapping("/goods/update")
    public String updateGoods(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam double price,
                                @RequestParam boolean product,
                              @RequestParam(defaultValue = "false")  boolean isDeleted) {
        GoodsModel newGoods = new GoodsModel(id, name,price, product, isDeleted);
        goodsService.updateGoods(newGoods);
        return "redirect:/goods";
    }

    @PostMapping("/goods/delete")
    public String deleteGoods(@RequestParam int id) {
        goodsService.deleteGoods(id);
        return "redirect:/goods";
    }
    private List<Integer> idents = new ArrayList<>();
    @PostMapping("/goods/logic_delete")
    public String logicDeleteGoods(@RequestParam int id) {
        idents.add(id);
        goodsService.logicDeleteGoods(id);
        return "redirect:/goods";
    }

    @PostMapping("/goods/deletes")
    public String deleteGoodss() {
        goodsService.deleteGoodss(idents);
        return "redirect:/goods";
    }
    @PostMapping("/goods/logic_deletes")
    public String logicDeleteGoodss(@RequestParam("ids") List<Integer> ids) {
        goodsService.logicDeleteGoodss(ids);
        return "redirect:/goods";
    }
    @PostMapping("/goods/search")
    public String searchGoodsByName(Model model,@RequestParam String name){
        model.addAttribute("goods", goodsService.searchGoodsByName(name));
        return "GoodsList";
    }
    @PostMapping("/goods/filter")
    public String filterGoods(Model model, @RequestParam int filterType) {
        model.addAttribute("goods", goodsService.filterGoods(filterType));
        return "GoodsList";
    }
    @PostMapping("/goods/restore")
    public String restoreAllDeletedGoods() {
        goodsService.restoreAllDeletedGoods();
        return "redirect:/goods";
    }
}
