package info.regismelo.application;

import java.util.Optional;

import info.regismelo.domain.model.Incident;
import info.regismelo.domain.model.IncidentAnalysis;
import info.regismelo.domain.ports.in.IncidentManagementPort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IncidentManagementService implements IncidentManagementPort {

    @Override
    public Optional<Incident> getIncidentDetails(String incidentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIncidentDetails'");
    }

    @Override
    public IncidentAnalysis analyzeIncidentWithLogs(String incidentId, String searchQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'analyzeIncidentWithLogs'");
    }

    @Override
    public void addWorkNoteToIncident(String incidentId, String workNoteText) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addWorkNoteToIncident'");
    }

    // private final IncidentRepositoryPort incidentRepository;
    // private final LogSearcherPort logSearcher;

    // @Inject
    // public IncidentManagementService(IncidentRepositoryPort incidentRepository, LogSearcherPort logSearcher) {
    //     this.incidentRepository = incidentRepository;
    //     this.logSearcher = logSearcher;
    // }

    // @Override
    // public Optional<Incident> getIncidentDetails(String incidentId) {
    //     return incidentRepository.findById(incidentId);
    // }

    // @Override
    // public IncidentAnalysis analyzeIncidentWithLogs(String incidentId, String searchQuery) {
    //     Incident incident = incidentRepository.findById(incidentId)
    //            .orElseThrow(() -> new IncidentNotFoundException(incidentId));

    //     if (!"Active".equalsIgnoreCase(incident.getStatus()) &&!"New".equalsIgnoreCase(incident.getStatus())) {
    //         throw new IllegalStateException("Only active or new incidents can be analyzed.");
    //     }

    //     String contextualQuery = searchQuery + " incident_id=" + incident.getId();
    //     List<LogEntry> logs = logSearcher.searchLogs(contextualQuery);

    //     return new IncidentAnalysis(incident, logs);
    // }

    // @Override
    // public void addWorkNoteToIncident(String incidentId, String workNoteText) {
    //     // Incident incident = incidentRepository.findById(incidentId)
    //     //        .orElseThrow(() -> new IncidentNotFoundException(incidentId));
        
    //     // incident.addWorkNote("System", workNoteText);
    //     // incidentRepository.save(incident);
    // }

}
