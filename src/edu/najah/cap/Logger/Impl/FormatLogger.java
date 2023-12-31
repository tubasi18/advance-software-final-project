package edu.najah.cap.Logger.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class FormatLogger extends Formatter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
    @Override
    public String format(LogRecord record) {
        String loggerName = record.getLoggerName();
        String loggerLevel = record.getLevel().getName();
        String message = record.getMessage();
        long timeStamp = record.getMillis();
        String dateString = getFormattedDate(timeStamp);
        return String.format("[%s] %s %s %s%n", loggerLevel, dateString, loggerName, message);
    }
    public  String getFormattedDate(long timeStamp){
        return DATE_FORMAT.format(new Date(timeStamp));
    }
}
