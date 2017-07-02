package cglibProxy;

/**
 * Created by Charley on 2017/6/4.
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecorcd = new ThreadLocal<MethodPerformance>();

    public static void begin(String method) {

        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecorcd.set(mp);
    }

    public static void end() {

        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecorcd.get();
        mp.printPerformance();
    }
}

