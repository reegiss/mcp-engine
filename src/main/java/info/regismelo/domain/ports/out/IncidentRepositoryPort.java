package info.regismelo.domain.ports.out;

import java.util.Optional;

import info.regismelo.domain.model.Incident;

public interface IncidentRepositoryPort {
    Optional<Incident> findById(String incidentId);
    void save(Incident incident);
}
