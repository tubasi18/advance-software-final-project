package edu.najah.cap.Logger.Intf;

public interface ILoggerHandler {
    void info(String MessageLogger);

    void warning(String messageLogger);

    void error(String MessageLogger);

    void debug(String MessageLogger);
}
