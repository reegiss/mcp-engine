package info.regismelo.adapter.out.splunk;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import info.regismelo.domain.model.LogEntry;
import info.regismelo.domain.ports.out.LogSearcherPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SplunkLogSearcherAdapter implements LogSearcherPort {

    @Inject
    @RestClient
    SplunkApi splunkApi;

    @ConfigProperty(name = "splunk.api.token")
    String apiToken;

    @ConfigProperty(name = "splunk.api.baseUrl")
    String apiBaseUrl;

    @Override
    @Fallback(fallbackMethod = "fallbackSearchLogs")
    public List<LogEntry> searchLogs(String query) {
        // TODO Auto-generated method stub
        // Cria o job de busca e aguarda o SID
        // Faz polling pelo status do job
        // Busca os resultados
        // Mapeia os resultados para o modelo de domínio

        throw new UnsupportedOperationException("Unimplemented method 'searchLogs'");
    }

    public List<LogEntry> fallbackSearchLogs(String query) {
        // Logar o erro e retornar uma lista vazia
        System.err.println("Splunk search failed for query: " + query + ". Executing fallback.");
        return Collections.emptyList();
    }

}
