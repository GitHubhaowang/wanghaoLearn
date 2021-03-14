package com.hh.io.bio;

import com.hh.io.bio.contain.SocketServerPool;
import com.hh.io.bio.server.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/2
 */
public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4399);
            SocketServerPool socketServerPool = new SocketServerPool(4);

            while (true) {
                Socket socket = serverSocket.accept();
                SocketServer socketServer = new SocketServer(socket);
                socketServerPool.excute(socketServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
