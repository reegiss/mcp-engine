package info.regismelo.domain.model;

import java.util.List;

public class IncidentAnalysis {

    private final Incident incident;
    private final List<LogEntry> relevantLogs;

    public IncidentAnalysis(Incident incident, List<LogEntry> relevantLogs) {
        this.incident = incident;
        this.relevantLogs = relevantLogs;
    }
    public Incident getIncident() {
        return incident;
    }
    public List<LogEntry> getRelevantLogs() {
        return relevantLogs;
    }
    @Override
    public String toString() {
        return "IncidentAnalysis{" +
                "incident=" + incident +
                ", relevantLogs=" + relevantLogs +
                '}';
    }
}
