package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Represents a Note in the address book.
 */
public class Note {
    public static final String MESSAGE_CONSTRAINTS =
        "Notes can only contain alphanumeric characters, spaces, "
        + "and common punctuation and it should not be blank.";

    public static final String MESSAGE_CONSTRAINTS_START_END_QUOTE =
        "Notes must start and end with a double quotation mark (\").";

    public static final String MESSAGE_CONSTRAINTS_BLANK =
        "Notes cannot be blank. It must contain at least one valid character.";

    public static final String MESSAGE_CONSTRAINTS_INVALID_CHARACTERS =
        "Notes can only contain basic Latin alphabet characters "
        + "(both uppercase and lowercase), numbers, common punctuation "
        + "marks, and whitespace.";

    public static final String VALIDATION_REGEX = "([a-zA-Z0-9 ,.!?;:'\"()\\-\\n]*)";

    private final String text;
    /**
     * Constructs a {@code Note}.
     */
    public Note() {
        this.text = "";
    }

    /**
     * Constructs a {@code Note}.
     *
     * @param text A valid note.
     */
    public Note(String text) {
        requireNonNull(text);
        this.text = text;
    }

    /**
     * Returns true if a given string is a valid note.
     */
    public static boolean isValidNote(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Note // instanceof handles nulls
            && text.equals(((Note) other).text)); // state check
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
