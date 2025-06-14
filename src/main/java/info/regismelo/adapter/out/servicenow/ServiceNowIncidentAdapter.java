package info.regismelo.adapter.out.servicenow;

import java.util.Base64;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import info.regismelo.adapter.out.servicenow.dto.ServiceNowIncidentPayload;
import info.regismelo.adapter.out.servicenow.mapper.ServiceNowMapper;
import info.regismelo.domain.model.Incident;
import info.regismelo.domain.ports.out.IncidentRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceNowIncidentAdapter implements IncidentRepositoryPort{

    @Inject
    @RestClient
    ServiceNowApi serviceNowApi;

    @Inject
    ServiceNowMapper mapper;

    @ConfigProperty(name = "servicenow.api.user")
    String apiUser;

    @ConfigProperty(name = "servicenow.api.password")
    String apiPassword;

    private String getAuthHeader() {
        String userPass = apiUser + ":" + apiPassword;
        return "Basic " + Base64.getEncoder().encodeToString(userPass.getBytes());
    }

    @Override
    @Retry(maxRetries = 3, delay = 200, jitter = 100)
    public Optional<Incident> findById(String incidentId) {
        try {
            ServiceNowIncidentPayload payload = serviceNowApi.getIncident(getAuthHeader(), incidentId);
            return Optional.ofNullable(mapper.toDomain(payload));
        } catch (Exception e) {
            // Logar o erro
            return Optional.empty();
        }
    }

    @Override
    @Retry(maxRetries = 2)
    public void save(Incident incident) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
