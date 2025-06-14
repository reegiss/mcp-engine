package info.regismelo.adapter.in.mcp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
@ApplicationScoped
public class ApiKeyAuthFilter implements ContainerRequestFilter {

    @ConfigProperty(name = "mcp.api.key")
    String validApiKey;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        if (requestContext.getUriInfo().getPath().startsWith("/mcp")) {
            String providedKey = requestContext.getHeaderString("X-API-Key");
            if (!validApiKey.equals(providedKey)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                       .entity("Invalid or missing API Key").build());
            }
        }
    }
}
