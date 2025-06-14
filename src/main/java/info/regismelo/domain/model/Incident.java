package info.regismelo.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents an incident with details such as id, description, status, priority, assignment group, and work notes.
 */
public class Incident {
    private String id;
    private String shortDescription;
    private String status;
    private String priority;
    private String assignmentGroup;
    private final List<WorkNote> workNotes;

    /**
     * Constructs an empty Incident with an empty list of work notes.
     */
    public Incident() {
        this.workNotes = new ArrayList<>();
    }

    /**
     * Constructs an Incident with the specified details.
     *
     * @param id the unique identifier of the incident
     * @param shortDescription a brief description of the incident
     * @param status the current status of the incident
     * @param priority the priority level of the incident
     * @param assignmentGroup the group assigned to the incident
     */
    public Incident(String id, String shortDescription, String status, String priority, String assignmentGroup) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.status = status;
        this.priority = priority;
        this.assignmentGroup = assignmentGroup;
        this.workNotes = new ArrayList<>();
    }

    /**
     * Adds a work note to the incident.
     *
     * @param author the author of the work note
     * @param text the content of the work note
     * @throws IllegalArgumentException if the text is null or blank
     */
    public void addWorkNote(String author, String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Work note text must not be null or blank");
        }
        workNotes.add(new WorkNote(author, text));
    }

    /**
     * Returns the unique identifier of the incident.
     *
     * @return the incident id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the incident.
     *
     * @param id the incident id
     * @throws NullPointerException if id is null
     */
    public void setId(String id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    /**
     * Returns the short description of the incident.
     *
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description of the incident.
     *
     * @param shortDescription the short description
     * @throws NullPointerException if shortDescription is null
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = Objects.requireNonNull(shortDescription, "shortDescription must not be null");
    }

    /**
     * Returns the status of the incident.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the incident.
     *
     * @param status the status
     * @throws NullPointerException if status is null
     */
    public void setStatus(String status) {
        this.status = Objects.requireNonNull(status, "status must not be null");
    }

    /**
     * Returns the priority of the incident.
     *
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the priority of the incident.
     *
     * @param priority the priority
     * @throws NullPointerException if priority is null
     */
    public void setPriority(String priority) {
        this.priority = Objects.requireNonNull(priority, "priority must not be null");
    }

    /**
     * Returns the assignment group of the incident.
     *
     * @return the assignment group
     */
    public String getAssignmentGroup() {
        return assignmentGroup;
    }

    /**
     * Sets the assignment group of the incident.
     *
     * @param assignmentGroup the assignment group
     * @throws NullPointerException if assignmentGroup is null
     */
    public void setAssignmentGroup(String assignmentGroup) {
        this.assignmentGroup = Objects.requireNonNull(assignmentGroup, "assignmentGroup must not be null");
    }

    /**
     * Returns an unmodifiable list of work notes associated with the incident.
     *
     * @return the list of work notes
     */
    public List<WorkNote> getWorkNotes() {
        return Collections.unmodifiableList(workNotes);
    }

    /**
     * Returns a string representation of the incident.
     *
     * @return a string representation of the incident
     */
    @Override
    public String toString() {
        return "Incident{" +
                "id='" + id + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", assignmentGroup='" + assignmentGroup + '\'' +
                ", workNotes=" + workNotes +
                '}';
    }
}