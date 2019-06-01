package com.botanik.logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;

/**
 *
 * @author teyyub , 8:05:49 AM
 */
public class Logger {

    static final String dir = System.getProperty("user.dir");
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Mylog");

    public Logger() {

    }

    public static void save(String message) {
        try {
             
            FileHandler fh = new FileHandler(dir + "/slog.txt");
            logger.addHandler(fh);
        } catch (IOException ex) {

        }

        logger.log(Level.INFO, message);
    }
}
