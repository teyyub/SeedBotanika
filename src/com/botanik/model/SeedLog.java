package com.botanik.model;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class SeedLog {

    static final Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;
    String cwd = System.getProperty("user.dir");
     
     public void log(String message) throws IOException{
         fh  = new FileHandler(cwd + "/" + "SeedLog.log");
         logger.warning(message);
     }
}
