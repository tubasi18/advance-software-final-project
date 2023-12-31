package edu.najah.cap.Logger.Impl;


import java.util.logging.Level;
import java.util.logging.Logger;
import edu.najah.cap.Logger.Intf.ILoggerHandler;
import java.util.logging.FileHandler;

public class LoggerHandler implements ILoggerHandler {
    private static final ILoggerHandler instance = null;
    private static final Logger logger = Logger.getLogger(LoggerHandler.class.getSimpleName());
    private LoggerHandler() {
        try {
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
            FileHandler fileHandler = new FileHandler("logs.log", true);
            fileHandler.setFormatter(new FormatLogger());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ILoggerHandler getInstance() {
        // implementation
        return  null;
    }

    @Override
    public void info(String MessageLogger) {
        //implementation
    }

    @Override
    public void warning(String messageLogger) {
        //implementation
    }

    @Override
    public void error(String MessageLogger) {
        //implementation
    }

    @Override
    public void debug(String MessageLogger) {
        //implementation
    }
}
