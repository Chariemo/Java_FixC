package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Charley on 2017/9/29.
 */
public class ZkDemo extends ConnectionWatcher {


    public void createGroup(String groupName) throws KeeperException, InterruptedException {

        String path = "/" + groupName;
        zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL.PERSISTENT);

    }

    public void deleteGroup(String groupName) {

        String path = "/" + groupName;

        try {
            List<String> children = zk.getChildren(path, false);
            for (String child : children) {
                zk.delete(child, -1);
            }
            zk.delete(path, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void list(String groupName) {

        String path = "/" + groupName;

        try {
            List<String> children = zk.getChildren(path, false);
            if (children.isEmpty()) {
                System.out.printf("No members in group %s\n", groupName);
                System.exit(1);
            }
            for (String child : children) {
                System.out.println(child);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZkDemo zkDemo = new ZkDemo();
        zkDemo.connect("123.206.122.65");
        zkDemo.deleteGroup("thirdGroup`");
        zkDemo.createGroup("thirdGroup");
        System.out.println("Zookeeper session established");
        zkDemo.list("");
        TimeUnit.SECONDS.sleep(5);
        zkDemo.close();

    }
}
