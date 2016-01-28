package com.concurrent.modell;

import java.util.Date;
import java.util.Objects;

public class LogMessage {

    private Date date;
    private Type type;
    private String message;

    public enum Type {
        INFO, ERROR
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMessage that = (LogMessage) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(type, that.type) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, type, message);
    }
}
