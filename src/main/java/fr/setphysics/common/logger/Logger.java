package fr.setphysics.common.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire gérant les logs de 7Physics.
 * Les logs sont sauvegardés dans le répertoire "logs" à la racine du projet appelant.
 */
public class Logger {
    private static final DateTimeFormatter TODAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter NOW_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static PrintWriter logWriter;
    private static final List<String> filteredPackage = new ArrayList<>();

    static {
        String today = TODAY_FORMATTER.format(LocalDateTime.now());
        int i = 0;
        File logFile;
        do {
            logFile = new File("logs/" + today + "_" + i + ".log");
            i++;
        } while (logFile.exists());
        logFile.getParentFile().mkdirs();
        try {
            logFile.createNewFile();
            logWriter = new PrintWriter(new FileWriter(logFile), true);
        } catch (IOException e) {
            System.err.println("FAILED TO START LOGGER:");
            e.printStackTrace();
        }
    }

    /**
     * Ajoute un filtre de package.
     * Tous les logs dont la classe appelante appartient à un package de préfixe {@code packagePrefix}.
     * @param packagePrefix Prefixe du package à filtrer
     */
    public static void addFilter(String packagePrefix) {
        filteredPackage.add(packagePrefix);
    }

    /**
     * Supprime un filtre de package.
     * @see Logger#addFilter(String)
     * @param packagePrefix Prefixe du package à filtrer
     */
    public static void removeFilter(String packagePrefix) {
        filteredPackage.remove(packagePrefix);
    }

    /**
     * Log un message de débogage
     * @param message message à afficher
     */
    public static void debug(String message) {
        addMessage(null, "DEBUG", message);
    }

    /**
     * Log un message d'information
     * @param message message à afficher
     */
    public static void info(String message) {
        addMessage("34", "INFO", message);
    }

    /**
     * Log un message de danger
     * @param message message à afficher
     */
    public static void warning(String message) {
        addMessage("33", "WARNING", message);
    }

    /**
     * Log un message d'erreur
     * @param message message à afficher
     */
    public static void error(String message) {
        addMessage("31", "ERROR", message);
    }

    /**
     * Ajoute un message (sur la sortie standard et dans un fichier).
     * @param color Numéro du code ANSI d'une couleur ou null pour pas de couleur.
     * @param type Type du message à ajouter. Ex: WARNING
     * @param message Message à ajouter.
     */
    private static void addMessage(String color, String type, String message) {
        StackTraceElement trace = Thread.currentThread().getStackTrace()[3];
        String clazz = trace.getClassName();
        boolean matchFilters = filteredPackage.isEmpty();
        for(String pack : filteredPackage) {
            if(clazz.startsWith(pack)) {
                matchFilters = true;
                break;
            }
        }
        if(!matchFilters) {
            return;
        }
        StringBuilder messageBuilder = new StringBuilder(message);
        messageBuilder.insert(0, "[" + type + "] " + NOW_FORMATTER.format(LocalDateTime.now()) + " " + trace + " : ");
        logWriter.println(messageBuilder.toString());
        if (color != null) {
            messageBuilder.insert(0, "\u001B[" + color + "m");
            messageBuilder.append("\u001B[0m");
        }
        System.out.println(messageBuilder.toString());
    }
}
