package com.concurrent.modell;

import java.util.List;
import java.util.Objects;

public class StatusAndLog {

    private Status status;
    private List<LogMessage> logMessages;

    public enum Status {
        NOT_RUNNING, IN_PROGRESS
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<LogMessage> getLogMessages() {
        return logMessages;
    }

    public void setLogMessages(List<LogMessage> logMessages) {
        this.logMessages = logMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusAndLog that = (StatusAndLog) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(logMessages, that.logMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, logMessages);
    }
}
