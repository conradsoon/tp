package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddNoteCommand;
import seedu.address.model.person.Note;

public class AddNoteCommandParserTest {
    private AddNoteCommandParser parser = new AddNoteCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        AddNoteCommand expectedCommand = new AddNoteCommand(Index.fromZeroBased(0), new Note("Test note"));
        assertParseSuccess(parser, "1 \"Test note\"", expectedCommand);
    }

    @Test
    public void parse_missingDetails_failure() {
        // Missing note details
        assertParseFailure(parser, "1",
            String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));

        // Missing index
        assertParseFailure(parser, "\"Test note\"",
            String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid index
        assertParseFailure(parser, "0 \"Test note\"",
            String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));

        // invalid characters in note
        assertParseFailure(parser, "1 \"Test @note\"",
            Note.MESSAGE_CONSTRAINTS_INVALID_CHARACTERS);

        // missing starting quotation mark
        assertParseFailure(parser, "1 Test note\"",
            Note.MESSAGE_CONSTRAINTS_START_END_QUOTE);

        // missing ending quotation mark
        assertParseFailure(parser, "1 \"Test note",
            Note.MESSAGE_CONSTRAINTS_START_END_QUOTE);

        // blank note
        assertParseFailure(parser, "1 \"\"",
            Note.MESSAGE_CONSTRAINTS_BLANK);
    }
}
