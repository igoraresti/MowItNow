package mowitnow.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class FileInputParserTest {

    private final FileInputParser parser = new FileInputParser();
    private static final String TEST_FILE = "src/test/resources/ficheros_dato/cesped";

    @Test
    @DisplayName("Should parse input file correctly")
    void parseFile() throws IOException {
        FileInputParser.SimulationInput input = parser.parse(TEST_FILE);

        assertThat(input.lawn().width()).isEqualTo(5);
        assertThat(input.lawn().height()).isEqualTo(5);
        assertThat(input.mowers()).hasSize(2);

        assertThat(input.mowers().get(0).getPosition().x()).isEqualTo(1);
        assertThat(input.mowers().get(0).getPosition().y()).isEqualTo(2);
        assertThat(input.mowers().get(0).getOrientation()).isEqualTo(mowitnow.domain.Orientation.N);
    }
}
