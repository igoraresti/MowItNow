package mowitnow.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimulationServiceTest {

    private final SimulationService simulationService = new SimulationService();

    @Test
    @DisplayName("Simulation should produce expected output for standard input")
    void runSimulation() throws IOException {
        List<String> results = simulationService.runSimulation("src/test/resources/ficheros_dato/cesped");

        assertThat(results).containsExactly(
                "1 3 N",
                "5 1 E"
        );
    }
}
