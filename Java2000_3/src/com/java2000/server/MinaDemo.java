package com.java2000.server;

import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaDemo {
    //创建接收数据的过滤器
    SocketAcceptor acceptor = new NioSocketAcceptor();
}
