package com.java2000.server.Mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MinaServer {
    public static void main(String[] args) {
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设定一个过滤器，一行一行地读取数据(/r/n)
//        chain.addLast("mychain",new ProtocolCodecFilter(new TextLineCodecFactory()));
        //设定过滤器以对象为单位读取数据
//        chain.addLast("objectFilter",new ProtocolCodecFactory(new ObjectSerializationCodecFactory()));
        // 设置服务器端的消息处理器
        acceptor.setHandler(new MinaServerHandler());
        int port = 9998; // 服务器的端口号;
        try {
            //绑定端口，启动服务器，不会阻塞、立即返回
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mina服务器已经运行！监听+"+port);
    }    
}
