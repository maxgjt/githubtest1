package com.java2000.gui;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends Frame{
    private TextField textField = new TextField(20);
    private Button button = new Button("付款");
    public Frame2(){
        this.setSize(600,400);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //把布局应用到窗体上
        this.setLayout(flowLayout);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = textField.getText();
                moneyListener.setMoney(money);
            }
        });
        this.add(textField);
        this.add(button);
        this.setVisible(true);
    }

    public MoneyListener moneyListener;

    public void setMoneyListener(MoneyListener moneyListener) {
        this.moneyListener = moneyListener;
    }

    public static interface MoneyListener{
        public void setMoney(String money);
    }

}
