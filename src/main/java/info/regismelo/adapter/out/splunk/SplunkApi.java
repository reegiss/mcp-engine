package info.regismelo.adapter.out.splunk;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import info.regismelo.adapter.out.splunk.dto.SplunkDtos.SplunkJobStatusResponse;
import info.regismelo.adapter.out.splunk.dto.SplunkDtos.SplunkSearchJobResponse;
import info.regismelo.adapter.out.splunk.dto.SplunkDtos.SplunkSearchResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/services/search")
@RegisterRestClient(configKey = "splunk-api")
public interface SplunkApi {

    @POST
    @Path("/jobs")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<SplunkSearchJobResponse> createSearchJob(@HeaderParam("Authorization") String auth, @FormParam("search") String search);

    @GET
    @Path("/jobs/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<SplunkJobStatusResponse> getSearchJobStatus(@HeaderParam("Authorization") String auth, @PathParam("sid") String sid);

    @GET
    @Path("/jobs/{sid}/results")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<SplunkSearchResponse> getSearchResults(@HeaderParam("Authorization") String auth, @PathParam("sid") String sid, @QueryParam("output_mode") String outputMode);
}
