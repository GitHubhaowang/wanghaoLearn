package com.hh.io.bio.client;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/2
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 4399);
            PrintStream ps = new PrintStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                ps.println(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
