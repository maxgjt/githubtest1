package com.java2000.project.ui;

import com.java2000.project.bean.Clothes;
import com.java2000.project.service.ClothesService;
import com.java2000.project.service.impl.ClothesServiceImpl;
import com.java2000.project.utils.ConsoleTable;

import java.util.List;

public class HomeClass extends BaseClass{
    public void show(){
        showProducts();
        print("welcome: "+currUser.getUsername());
        boolean flag = true;
        while(flag){
            print(getString("home.function"));
            print(getString("info.select"));
            String select  = input.nextLine();
            switch (select){
                case "0":
                    flag = false;
                    System.exit(0);
                    break;
                case "1": //1.查询全部订单
                    flag = false;
                    findList();
                    break;
                case "2": //2.查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3": //3.购买;
                    buyProducts();
                    flag = false;
                    break;
                default:
                    print(getString("input.error"));
                    break;
            }
        }
    }

    private void buyProducts() {

    }

    private void findOrderById() {

    }

    private void findList() {
    }
    

    private void showProducts() {
        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8,true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");

        for (Clothes c:list){
            t.appendRow();
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }

        print(t.toString());
    }
}
