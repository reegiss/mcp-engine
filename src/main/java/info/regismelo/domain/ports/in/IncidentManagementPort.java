package info.regismelo.domain.ports.in;

import java.util.Optional;

import info.regismelo.domain.model.Incident;
import info.regismelo.domain.model.IncidentAnalysis;

public interface IncidentManagementPort {
    Optional<Incident> getIncidentDetails(String incidentId);
    IncidentAnalysis analyzeIncidentWithLogs(String incidentId, String searchQuery);
    void addWorkNoteToIncident(String incidentId, String workNoteText);
}
