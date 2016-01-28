package com.concurrent.service;

import com.concurrent.modell.LogMessage;
import com.concurrent.modell.LogMessage.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.concurrent.modell.LogMessage.Type.ERROR;
import static com.concurrent.modell.LogMessage.Type.INFO;

@Component
public class LogServiceImpl implements LogService {

    List<LogMessage> messages = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void error(String message) {
        add(message, ERROR);
    }

    @Override
    public void info(String message) {
        add(message, INFO);
    }

    private void add(String message, Type type) {
        LogMessage logMessage = new LogMessage();
        logMessage.setDate(new Date());
        logMessage.setMessage(message);
        logMessage.setType(type);
        messages.add(logMessage);
    }

    @Override
    public List<LogMessage> getLogs() {
        List<LogMessage> messagesOfTestCase = Collections.unmodifiableList(new ArrayList<>(messages));
        messages.clear();
        return messagesOfTestCase;
    }
}
