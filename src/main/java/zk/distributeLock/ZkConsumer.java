package zk.distributeLock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.SessionTracker;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkConsumer implements Watcher {
    public CountDownLatch latch = new CountDownLatch(1);
    public int status = 0;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String CONN = "localhost:2181,localhost:2182,localhost:2183,localhost:2184";
        ZooKeeper zk = new ZooKeeper(CONN, 5000, null);

        ZkConsumer watcher = new ZkConsumer();
        long sessionId = zk.getSessionId();

        while (!watcher.tryLock(zk, "/lock", (Watcher) watcher)) {
            Thread.sleep(1000);
        }
        watcher.setValue(zk, "/count");
        zk.close();

    }

    public void setValue(ZooKeeper zk, String path) throws KeeperException, InterruptedException {
        Stat stat = zk.exists("/count",false);
        byte[] data = zk.getData(path, false, null);
        if (data == null) {
            System.out.println("dont exist");
        }
        String str = new String(data);
        System.out.println(str);
        int curValue = Integer.parseInt(str);
        int version = stat.getVersion();
        Integer newValue = (new Integer(curValue)) + 1;
        zk.setData(path, newValue.toString().getBytes(),  version);
    }


    public boolean tryLock(ZooKeeper zk, String path, Watcher watcher){
        try {
            zk.create("/lock", "Session".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            return true;
        } catch (KeeperException e) {
        } catch (InterruptedException e) {

        }
        return false;
    }

    public void gotoNext(){

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
