package com.hh.io.bio.contain;

import com.hh.io.bio.server.SocketServer;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/2
 */
public class SocketServerPool {
    private ThreadPoolExecutor tpe;

    public SocketServerPool(int maxConn) {
        tpe = new ThreadPoolExecutor(maxConn, maxConn, 5000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public void excute(SocketServer socketServer) {
        tpe.execute(socketServer);
    }
}
