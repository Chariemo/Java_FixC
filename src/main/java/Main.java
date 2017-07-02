import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.activemq.*;

public class Main {


    public static void main(String[] args) {

//        String str1 = new String("abc");
//        str1.intern();
//        String str2 = "abc";
//
//        System.out.println(str1 == str2);
//
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("java").toString();
//        System.out.println(str2.intern() == str2);

//        String str1 = new String("1");
//        str1.intern();
//        String str2 = "1";
//        System.out.println(str1 == str2);

        String str1 = new String("1") + new String("2");
        str1.intern();
        String str2 = "12";
        System.out.println(str2 == str1);

    }
}
