package zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Random;

public class TaskMaster {
    static String status = "ACTIVE";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String CONN = "localhost:2181,localhost:2182,localhost:2183,localhost:2184";

        ZooKeeper zk = new ZooKeeper(CONN, 5000, null);

        byte[] data = zk.getData("/lsy", false, null);
        if (data == null) {
            System.out.println("111111");
        }
        System.out.println(new String(data));

        try {
            String result = zk.create("/lsy",  "lsyslh".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        } catch (KeeperException.NodeExistsException e) {
            //e.printStackTrace();
        }




//        String IP = "202.106.29.138";
//        String port = new Random().nextInt(500) + "";
//
//        System.out.println(port);
//
//        if (zk.exists("/tack/master", new MasterWatcher()) != null) {
//            status = "STANDBY";
//        } else {
//            zk.create("/tack/master",  (IP + ":" + port).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
//            status = "ACTIVE";
//            System.out.println("启动就是 active");
//        }
//
//        Thread.sleep(Integer.MAX_VALUE);



    }

    private static class MasterWatcher implements Watcher {

        public void process(WatchedEvent e) {
            if (e.getType()  == Event.EventType.NodeDeleted) {
                status = "ACTIVE";
                System.out.println("切换回 active");
            }
        }
    }
}

