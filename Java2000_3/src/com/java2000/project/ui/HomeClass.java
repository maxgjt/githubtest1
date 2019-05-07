package com.java2000.project.ui;

import com.java2000.project.bean.Clothes;
import com.java2000.project.bean.Order;
import com.java2000.project.bean.OrderItem;
import com.java2000.project.service.ClothesService;
import com.java2000.project.service.OrderService;
import com.java2000.project.service.impl.ClothesServiceImpl;
import com.java2000.project.service.impl.OrderServiceImpl;
import com.java2000.project.utils.ConsoleTable;
import com.java2000.project.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{
    private OrderService orderService = new OrderServiceImpl();
    private ClothesService clothesService = new ClothesServiceImpl();
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
                    try {
                        buyProducts();
                        flag = false;
                    }catch (BusinessException e){
                        print(e.getMessage());
                    }
                    break;
                default:
                    print(getString("input.error"));
                    break;
            }
        }
    }
    //购买商品
    private void buyProducts() throws BusinessException{
        // 生成订单
        boolean flag = true;
        int count =1;
        float sum =0.0f;  // 订单总金额
        Order order = new Order(); //生成的订单
        while (flag){
            print(getString("product.input.id"));
            String id =input.nextLine();
            print(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();

            Clothes clothes=clothesService.findById(id);
            int num = Integer.parseInt(shoppingNum);
            if (num>clothes.getNum()){
                throw new BusinessException("product.num.error");
            }

            //一条订单明细
            clothes.setNum(clothes.getNum()-num); //减库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);

            print(getString("product.buy.continue"));
            String isBuy = input.nextLine();
            switch (isBuy){
                case "1":
                    break;
                case "2":
                    flag=false;
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        showProducts();
    }

    private void findOrderById() {

    }

    private void findList() {
    }
    

    private void showProducts() {
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
