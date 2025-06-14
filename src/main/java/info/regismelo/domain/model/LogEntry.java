package info.regismelo.domain.model;

import java.time.ZonedDateTime;

public class LogEntry {

    private ZonedDateTime timestamp;
    private String level;
    private String message;

    public LogEntry(ZonedDateTime timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "timestamp=" + timestamp +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
