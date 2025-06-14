package info.regismelo.adapter.out.servicenow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ServiceNowIncidentPayload {
    private final Result result;

    public ServiceNowIncidentPayload(@JsonProperty("result") Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public static final class Result {
        @JsonProperty("sys_id")
        private final String sysId;

        @JsonProperty("short_description")
        private final String shortDescription;

        @JsonProperty("state")
        private final String state;

        @JsonProperty("priority")
        private final String priority;

        @JsonProperty("assignment_group")
        private final String assignmentGroup;

        @JsonProperty("comments_and_work_notes")
        private final String commentsAndWorkNotes;

        public Result(
            @JsonProperty("sys_id") String sysId,
            @JsonProperty("short_description") String shortDescription,
            @JsonProperty("state") String state,
            @JsonProperty("priority") String priority,
            @JsonProperty("assignment_group") String assignmentGroup,
            @JsonProperty("comments_and_work_notes") String commentsAndWorkNotes
        ) {
            this.sysId = sysId;
            this.shortDescription = shortDescription;
            this.state = state;
            this.priority = priority;
            this.assignmentGroup = assignmentGroup;
            this.commentsAndWorkNotes = commentsAndWorkNotes;
        }

        public String getSysId() {
            return sysId;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public String getState() {
            return state;
        }

        public String getPriority() {
            return priority;
        }

        public String getAssignmentGroup() {
            return assignmentGroup;
        }

        public String getCommentsAndWorkNotes() {
            return commentsAndWorkNotes;
        }
    }
}