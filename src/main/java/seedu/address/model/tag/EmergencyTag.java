package seedu.address.model.tag;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Emergency Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class EmergencyTag extends Tag {

    public static final String MESSAGE_CONSTRAINTS = "Emergency tags should be RA or SOS";

    /**
     * Defines valid emergency tag names.
     * <p>
     * RA: (Residential Assistant)
     * SOS: (Security Officer of the School)
     */
    public enum EmergencyTagName {
        RA, SOS
    }

    /**
     * Constructs a {@code EmergencyTag}.
     *
     * @param tagName A valid tag name.
     */
    public EmergencyTag(String tagName) {
        super(tagName);
        // Additional check for emergency tag
        checkArgument(isValidEmergencyTagName(tagName), MESSAGE_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid emergency tag name.
     */
    public static boolean isValidEmergencyTagName(String test) {
        try {
            EmergencyTagName.valueOf(test);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
