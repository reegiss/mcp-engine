package info.regismelo.domain.ports.out;

import java.util.List;

import info.regismelo.domain.model.LogEntry;

public interface LogSearcherPort {
    List<LogEntry> searchLogs(String query);
}
