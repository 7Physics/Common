package fr.setphysics.common.logger;

public class Logger {
    public static void main(String[] args) {
        Logger.info("test");
    }

    public static void info(String message) {
        System.out.println("[INFO] "+Thread.currentThread().getStackTrace()[2] + " : " + message);
    }
}
