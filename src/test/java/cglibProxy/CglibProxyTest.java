package cglibProxy;

import org.junit.Test;

/**
 * Created by Charley on 2017/6/4.
 */
public class CglibProxyTest {

    @Test
    public void getProxy() throws Exception {

        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumService.class);
        forumService.removeTopic(24);
        forumService.removeForum(23);
    }

}