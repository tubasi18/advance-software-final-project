package edu.najah.cap.Logger.Impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.najah.cap.Logger.Intf.ILoggerHandler;

import java.util.logging.FileHandler;


public class LoggerHandler implements ILoggerHandler {
    private static ILoggerHandler instance = null;
    private static final Logger logger = Logger.getLogger(LoggerHandler.class.getSimpleName());

    private LoggerHandler() {
        try {

            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
            FileHandler fileHandler = new FileHandler("_logs.log", true);
            fileHandler.setFormatter(new FormatLogger());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized ILoggerHandler getInstance() {
        if (instance == null) {
            instance = new LoggerHandler();
        }
        return instance;
    }

    @Override
    public void info(String MessageLogger) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        logger.info(String.format("[%s.%s] %s", className, methodName, MessageLogger));
    }

    @Override
    public void warning(String messageLogger) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        logger.warning(String.format("[%s.%s] %s", className, methodName, messageLogger));
    }

    @Override
    public void error(String MessageLogger, Throwable throwable) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        logger.severe(String.format("[%s.%s] %s", className, methodName, MessageLogger, throwable));
    }

    @Override
    public void debug(String MessageLogger) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        logger.fine(String.format("[%s.%s] %s", className, methodName, MessageLogger));
    }
}
