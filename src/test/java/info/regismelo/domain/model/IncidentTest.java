package info.regismelo.domain.model;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class IncidentTest {

    private Incident incident;

    @BeforeEach
    void setUp() {
        incident = new Incident("1", "desc", "open", "high", "IT");
    }

    @Test
    void testDefaultConstructorInitializesWorkNotes() {
        Incident inc = new Incident();
        assertNotNull(inc.getWorkNotes());
        assertTrue(inc.getWorkNotes().isEmpty());
    }

    @Test
    void testParameterizedConstructorSetsFields() {
        assertEquals("1", incident.getId());
        assertEquals("desc", incident.getShortDescription());
        assertEquals("open", incident.getStatus());
        assertEquals("high", incident.getPriority());
        assertEquals("IT", incident.getAssignmentGroup());
        assertTrue(incident.getWorkNotes().isEmpty());
    }

    @Test
    void testSettersAndGetters() {
        incident.setId("2");
        incident.setShortDescription("new desc");
        incident.setStatus("closed");
        incident.setPriority("low");
        incident.setAssignmentGroup("HR");

        assertEquals("2", incident.getId());
        assertEquals("new desc", incident.getShortDescription());
        assertEquals("closed", incident.getStatus());
        assertEquals("low", incident.getPriority());
        assertEquals("HR", incident.getAssignmentGroup());
    }

    @Test
    void testSettersThrowOnNull() {
        assertThrows(NullPointerException.class, () -> incident.setId(null));
        assertThrows(NullPointerException.class, () -> incident.setShortDescription(null));
        assertThrows(NullPointerException.class, () -> incident.setStatus(null));
        assertThrows(NullPointerException.class, () -> incident.setPriority(null));
        assertThrows(NullPointerException.class, () -> incident.setAssignmentGroup(null));
    }

    @Test
    void testAddWorkNoteThrowsOnNullOrBlank() {
        assertThrows(IllegalArgumentException.class, () -> incident.addWorkNote("Bob", null));
        assertThrows(IllegalArgumentException.class, () -> incident.addWorkNote("Bob", ""));
        assertThrows(IllegalArgumentException.class, () -> incident.addWorkNote("Bob", "   "));
    }

    @Test
    void testGetWorkNotesReturnsUnmodifiableList() {
        incident.addWorkNote("Alice", "Note 1");
        List<WorkNote> notes = incident.getWorkNotes();
        assertThrows(UnsupportedOperationException.class, () -> notes.add(new WorkNote("Bob", "Note 2")));
    }

    @Test
    void testToStringContainsFields() {
        incident.addWorkNote("Alice", "Note 1");
        String str = incident.toString();
        assertTrue(str.contains("id='1'"));
        assertTrue(str.contains("shortDescription='desc'"));
        assertTrue(str.contains("status='open'"));
        assertTrue(str.contains("priority='high'"));
        assertTrue(str.contains("assignmentGroup='IT'"));
        assertTrue(str.contains("workNotes=["));
    }
}
