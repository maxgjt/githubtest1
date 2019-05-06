package com.java2000.gui;

import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameDemo extends Frame implements ActionListener{

    public static void main(String[] args) {
        new MyFrameDemo();
    }

    public MyFrameDemo() throws HeadlessException {
        this.setSize(600,400);
        this.setTitle("我的第一个GUI 窗体");
        //创建一个按钮
        Button button = new Button("点击有惊喜");
        //给按钮添加单击事件
        button.addActionListener((ActionListener) this);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //把布局应用到窗体上
        this.setLayout(flowLayout);

        //把按钮添加到窗体上
        this.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("恭喜啦");
    }
}
