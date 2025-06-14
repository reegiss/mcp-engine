package info.regismelo.domain.exception;

public class IncidentNotFoundException extends RuntimeException {
    public IncidentNotFoundException(String incidentId) {
        super("Incident with ID " + incidentId + " not found.");
    }
}
