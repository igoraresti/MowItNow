package mowitnow.infrastructure;

import mowitnow.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileInputParser {

    public record SimulationInput(Lawn lawn, List<Mower> mowers) {}

    public SimulationInput parse(String filePath) throws IOException {
        List<String> lines;
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream.filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());
        }

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String[] lawnDims = lines.get(0).split(" ");
        Lawn lawn = new Lawn(Integer.parseInt(lawnDims[0]), Integer.parseInt(lawnDims[1]));

        List<Mower> mowers = new ArrayList<>();
        for (int i = 1; i < lines.size(); i += 2) {
            String[] mowerPos = lines.get(i).split(" ");
            Position position = new Position(Integer.parseInt(mowerPos[0]), Integer.parseInt(mowerPos[1]));
            Orientation orientation = Orientation.valueOf(mowerPos[2]);

            String instructionLine = lines.get(i + 1);
            List<Instruction> instructions = instructionLine.chars()
                    .mapToObj(c -> Instruction.fromChar((char) c))
                    .collect(Collectors.toList());

            mowers.add(new Mower(position, orientation, instructions));
        }

        return new SimulationInput(lawn, mowers);
    }
}
