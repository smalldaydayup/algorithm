package io.new_io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiNioDemo {
    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9090;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector = Selector.open();

            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("Server run success ........");

        try {
            while (true) {
                Set<SelectionKey> keys = selector.keys();
                System.out.println(keys.size() + " size");

                while (selector.select(500) > 0) {
                    Set<SelectionKey> selectionKeys =  selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();

                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();

                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void acceptHandler(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel client = ssc.accept();
        client.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(8192);
        client.register(selector, SelectionKey.OP_READ, buffer);
        System.out.println("--------------------------------------");
        System.out.println("新客户端： " + client.getRemoteAddress());
        System.out.println("--------------------------------------");
    }
}
