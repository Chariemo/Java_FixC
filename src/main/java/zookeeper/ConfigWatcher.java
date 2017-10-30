package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Charley on 2017/10/24.
 */
public class ConfigWatcher implements Watcher {

    private ActiveKeyValueStore store;

    public ConfigWatcher(String hosts) throws IOException, InterruptedException {

        store = new ActiveKeyValueStore();
        store.connect(hosts);
    }

    public void displayConfig() throws KeeperException, InterruptedException {

        String value = store.read(ConfigUpdate.PATH, this);
        System.out.printf("Read %s as %s\n", ConfigUpdate.PATH, value);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

        if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
            try {
                displayConfig();
            } catch (InterruptedException e) {
                System.err.println("Interrupted. Exiting");
            } catch (KeeperException e) {
                System.err.printf("KeeperException: %s. Exiting", e);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ConfigWatcher configWatcher = new ConfigWatcher("123.206.122.65");
        configWatcher.displayConfig();

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }
}
