package mowitnow.application;

import mowitnow.domain.Mower;
import mowitnow.infrastructure.FileInputParser;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SimulationService {
    private final FileInputParser parser;

    public SimulationService() {
        this.parser = new FileInputParser();
    }

    public List<String> runSimulation(String filePath) throws IOException {
        FileInputParser.SimulationInput input = parser.parse(filePath);

        return input.mowers().stream()
                .map(mower -> {
                    mower.executeInstructions(input.lawn());
                    return mower.toString();
                })
                .collect(Collectors.toList());
    }
}
