package util;

/**
 * Created by Administrator on 2015/11/23.
 */
public class Logger {

    public static void info(String msg) {
        System.out.println("INFO - " + msg);
    }

    public static void error(Throwable e) {
        e.printStackTrace(System.out);
    }

    public static void error(String msg) {
        System.out.println("ERROR - " + msg);
    }

}
