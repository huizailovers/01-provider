package run;

import org.apache.dubbo.container.Main;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class Run {

    public static void main(String[] args) throws Exception{
        Main.main(args);


        /*ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 30000, new TestWatcher());
        String node = "/node2";
        Stat stat = zooKeeper.exists(node,false);
        if(null == stat){
            //创建节点
            String result = zooKeeper.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(result);
        }
        zooKeeper.close();
        String s = zooKeeper.toString();*/

    }

    static class TestWatcher implements Watcher{


        @Override
        public void process(WatchedEvent event) {
            System.out.println("---------");
        }
    }
}
