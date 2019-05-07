package com.java2000.project.service;

import com.java2000.project.bean.Order;
import com.java2000.project.ui.BusinessException;

import java.util.List;

public interface OrderService {
    public void buyProduct(Order o) throws BusinessException;
    public List<Order> list() throws BusinessException;
    public Order findById(int orderId) throws BusinessException;
}
