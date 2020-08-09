package io.new_io;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(8989));
        Selector selector = Selector.open();



        new Thread(new HandleSelector(selector)).start();
        while (!Thread.currentThread().isInterrupted()) {
            SocketChannel sc = server.accept();
            if (sc != null) {
                sc.register(selector, SelectionKey.OP_READ);
            }
        }

    }
}

class HandleSelector implements Runnable  {
    private Selector selector;

    public HandleSelector (Selector selector) {
        this.selector = selector;
    }


    @Override
    public void run() {
        while (true) {
            try {
                if (selector.select() > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while(iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isConnectable()) {
                            SocketChannel sc = (SocketChannel) selectionKey.channel();

                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            while (sc.read(buffer) > 0) {
                                buffer.flip();
                                System.out.println(new String(buffer.array()));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
