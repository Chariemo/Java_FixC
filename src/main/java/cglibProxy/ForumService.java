package cglibProxy;

/**
 * Created by Charley on 2017/6/3.
 */
public class ForumService {

    public void removeTopic(int topicId) {

        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeForum(int formId) {

        System.out.println("模拟删除Form记录:" + formId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
