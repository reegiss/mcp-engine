package info.regismelo.adapter.out.servicenow.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import info.regismelo.adapter.out.servicenow.dto.ServiceNowIncidentPayload;
import info.regismelo.adapter.out.servicenow.dto.ServiceNowUpdatePayload;
import info.regismelo.domain.model.Incident;
import info.regismelo.domain.model.WorkNote;

/**
 * Maps between ServiceNow DTOs and domain Incident model.
 */
@Mapper(componentModel = "cdi")
public interface ServiceNowMapper {

    /**
     * Converts a ServiceNowIncidentPayload to a domain Incident.
     *
     * @param payload the ServiceNow incident payload
     * @return the mapped Incident
     */
    @Mapping(source = "result.sysId", target = "id")
    @Mapping(source = "result.shortDescription", target = "shortDescription")
    @Mapping(source = "result.state", target = "status")
    Incident toDomain(ServiceNowIncidentPayload payload);

    /**
     * Converts a domain Incident to a ServiceNowUpdatePayload.
     *
     * @param incident the domain Incident
     * @return the mapped ServiceNowUpdatePayload
     */
    @Mapping(source = "workNotes", target = "work_notes")
    ServiceNowUpdatePayload toUpdatePayload(Incident incident);

    default String map(List<WorkNote> workNotes) {
        return workNotes == null ? null : workNotes.stream()
            .map(WorkNote::getText) // adjust to your field name
            .collect(Collectors.joining("\n"));
    }

}