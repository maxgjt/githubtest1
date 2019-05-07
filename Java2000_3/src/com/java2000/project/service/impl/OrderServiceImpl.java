package com.java2000.project.service.impl;

import com.java2000.project.bean.Order;
import com.java2000.project.service.OrderService;
import com.java2000.project.ui.BusinessException;
import com.java2000.project.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByorderId(orderId);
    }
}
