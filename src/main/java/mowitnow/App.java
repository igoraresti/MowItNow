package mowitnow;

import mowitnow.application.SimulationService;

import java.io.IOException;
import java.util.List;

public class App {
    
    private static final String PATH_FICHEROS_CONFIG = "src/test/resources/ficheros_dato/";
    
    public static void main(String[] args) {
        String fileName = "cesped";
        if (args.length > 0) {
            fileName = args[0];
        }

        SimulationService simulationService = new SimulationService();
        try {
            List<String> results = simulationService.runSimulation(PATH_FICHEROS_CONFIG + fileName);
            results.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during simulation: " + e.getMessage());
        }
    }
}
