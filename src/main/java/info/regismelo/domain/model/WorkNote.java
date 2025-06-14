package info.regismelo.domain.model;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Represents a note created by an author with a timestamp.
 */
public final class WorkNote {

    private final String author;
    private final String text;
    private final ZonedDateTime timestamp;

    /**
     * Constructs a WorkNote with the specified author and text.
     *
     * @param author the author of the note, must not be null or blank
     * @param text the content of the note, must not be null or blank
     * @throws IllegalArgumentException if author or text is null or blank
     */
    public WorkNote(String author, String text) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author must not be null or blank");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text must not be null or blank");
        }
        this.author = author;
        this.text = text;
        this.timestamp = ZonedDateTime.now();
    }

    /**
     * Returns the author of the note.
     *
     * @return the author of the note
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the content of the note.
     *
     * @return the text of the note
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the timestamp when the note was created.
     *
     * @return the creation timestamp of the note
     */
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Returns a string representation of the WorkNote.
     *
     * @return a string containing the author, text, and timestamp
     */
    @Override
    public String toString() {
        return String.format("WorkNote{author='%s', text='%s', timestamp=%s}", author, text, timestamp);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkNote)) return false;
        WorkNote workNote = (WorkNote) o;
        return author.equals(workNote.author) &&
               text.equals(workNote.text) &&
               timestamp.equals(workNote.timestamp);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(author, text, timestamp);
    }
}