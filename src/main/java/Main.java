import java.util.*;

public class Main {

    public static void fun() throws Exception {

        try {
            throw new Exception();
        } finally {
            System.out.println("finally");
        }
    }
    public static void main(String[] args) {

        try {
            fun();
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println("finished");
    }
}

