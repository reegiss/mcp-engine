package info.regismelo.adapter.in.mcp;

import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import info.regismelo.domain.model.Incident;
import info.regismelo.domain.ports.in.IncidentManagementPort;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

record McpRequest(String method, JsonNode params) {}

@Path("/mcp")
public class McpServerResource {

    @Inject
    IncidentManagementPort incidentManagement;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @POST
    @Path("/request")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleMcpRequest(McpRequest request) {
        try {
            switch (request.method()) {
                case "tools/getIncidentDetails":
                    String incidentId = request.params().get("incidentId").asText();
                    Optional<Incident> incident = incidentManagement.getIncidentDetails(incidentId);
                    return Response.ok(buildMcpSuccessResponse(incident.orElse(null))).build();

                case "tools/analyzeIncidentWithLogs":
                    String analyzeId = request.params().get("incidentId").asText();
                    String query = request.params().get("searchQuery").asText();
                    var analysis = incidentManagement.analyzeIncidentWithLogs(analyzeId, query);
                    return Response.ok(buildMcpSuccessResponse(analysis)).build();

                case "tools/addWorkNoteToIncident":
                    String noteIncidentId = request.params().get("incidentId").asText();
                    String workNoteText = request.params().get("workNoteText").asText();
                    incidentManagement.addWorkNoteToIncident(noteIncidentId, workNoteText);
                    return Response.ok(buildMcpSuccessResponse("Work note added successfully.")).build();

                default:
                    return Response.status(Response.Status.NOT_FOUND)
                           .entity(buildMcpErrorResponse(-32601, "Method not found"))
                           .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   .entity(buildMcpErrorResponse(-32603, "Internal error: " + e.getMessage()))
                   .build();
        }
    }

    private ObjectNode buildMcpSuccessResponse(Object result) {
        ObjectNode response = objectMapper.createObjectNode();
        response.put("jsonrpc", "2.0");
        response.set("result", objectMapper.valueToTree(result));
        response.putNull("id");
        return response;
    }

    private ObjectNode buildMcpErrorResponse(int code, String message) {
        ObjectNode response = objectMapper.createObjectNode();
        response.put("jsonrpc", "2.0");
        ObjectNode error = response.putObject("error");
        error.put("code", code);
        error.put("message", message);
        response.putNull("id");
        return response;
    }
}
