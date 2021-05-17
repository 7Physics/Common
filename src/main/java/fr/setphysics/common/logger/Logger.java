package fr.setphysics.common.logger;

public class Logger {
    public static void debug(String message) {
        System.out.println("[DEBUG] "+Thread.currentThread().getStackTrace()[2] + " : " + message);
    }

    public static void info(String message) {
        System.out.println("\u001B[34m[INFO] "+Thread.currentThread().getStackTrace()[2] + " : " + message+"\u001B[0m");
    }

    public static void warning(String message) {
        System.out.println("\u001B[33m[WARNING] "+Thread.currentThread().getStackTrace()[2] + " : " + message+"\u001B[0m");
    }

    public static void error(String message) {
        System.out.println("\u001B[31m[ERROR] "+Thread.currentThread().getStackTrace()[2] + " : " + message+"\u001B[0m");
    }
}
