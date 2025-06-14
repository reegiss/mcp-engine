package info.regismelo.adapter.out.servicenow;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import info.regismelo.adapter.out.servicenow.dto.ServiceNowIncidentPayload;
import info.regismelo.adapter.out.servicenow.dto.ServiceNowUpdatePayload;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/now/table")
@RegisterRestClient(configKey = "servicenow-api")
public interface ServiceNowApi {

    @GET
    @Path("/incident/{sys_id}")
    @Produces(MediaType.APPLICATION_JSON)
    ServiceNowIncidentPayload getIncident(@HeaderParam("Authorization") String auth, @PathParam("sys_id") String sysId);

    @PATCH
    @Path("/incident/{sys_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateIncident(@HeaderParam("Authorization") String auth, @PathParam("sys_id") String sysId, ServiceNowUpdatePayload payload);
}
