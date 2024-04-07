package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileReaderTest {
    private static FileReader fileReader;
    private static final String FILENAME = "src/test/resources/input.csv";
    private static final String NONEXISTED_FILENAME = "nonexistedfile.csv";
    private static final String INVALID_FORMAT_FILENAME = "src/test/resources/text.txt";

    @BeforeAll
    public static void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void read_SuccessfulRead_Ok() {
        ArrayList<String> textFromFile = fileReader.read(FILENAME);
        assertEquals(8, textFromFile.size());
    }

    @Test
    void read_FileNotFound_notOk() {
        assertThrows(RuntimeException.class, () -> fileReader.read(NONEXISTED_FILENAME));
    }

    @Test
    void read_InvalidFileFormat() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.read(INVALID_FORMAT_FILENAME);
        });
    }
}