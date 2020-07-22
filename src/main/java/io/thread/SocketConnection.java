package io.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketConnection {
    public static void main(String[] args) throws IOException {
        ExecutorService ex = Executors.newFixedThreadPool(50);
        
        ServerSocket sc = new ServerSocket(8080);
        while (!Thread.currentThread().isInterrupted()) {
            Socket s = sc.accept();
            ex.submit(new HandleConn(s));
        }
    }
}

class HandleConn implements Runnable {
    private Socket sc;

    public HandleConn (Socket sc) {
        this.sc = sc;
    }


    @Override
    public void run() {
        System.out.printf("Thread name : %s start handle conn", Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted() && !sc.isClosed()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                String mess = br.readLine();
                System.out.printf("I have handle info %s\n", mess);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
                bw.write(String.format("I have handle info %s", mess));
                bw.flush();
                if (mess.equals("shut down")) {
                    bw.write(String.format("I get close info:  %s", mess));
                    sc.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("I will close ");
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
