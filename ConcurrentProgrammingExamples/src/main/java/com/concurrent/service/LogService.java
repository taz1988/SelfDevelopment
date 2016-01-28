package com.concurrent.service;

import com.concurrent.modell.LogMessage;

import java.util.List;

public interface LogService {
    /**
     * Log an error message.
     * @param message
     */
    void error(String message);

    /**
     * Log an info message.
     * @param message
     */
    void info(String message);

    /**
     * get messages
     * @return
     */
    List<LogMessage> getLogs();
}
