package com.java2000.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends Frame implements Frame2.MoneyListener{
    private Label label = new Label("金额");
    private Button button = new Button("购买");
    public Frame1(){
        this.setSize(600,400);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //把布局应用到窗体上
        this.setLayout(flowLayout);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2().setMoneyListener(Frame1.this);
            }
        });

        //把按钮添加到窗体上
        this.add(label);
        this.add(button);
        this.setVisible(true);
    }


    @Override
    public void setMoney(String money) {
        label.setText(money);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
