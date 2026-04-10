# MowItNow

## Overview / Descripción

MowItNow is a Java-based simulation of automatic mowers navigating a rectangular lawn. This project implements a clean architecture with domain-driven design principles, using the latest Java features.

MowItNow es una simulación en Java de cortacéspedes automáticos que navegan por un césped rectangular. Este proyecto implementa una arquitectura limpia con principios de diseño orientado al dominio (DDD), utilizando las últimas características de Java.

## Features / Características

- **Java 21**: Utilizes modern features like Records and Pattern Matching for Switch.
- **Clean Architecture**: Separation of concerns between domain, application, and infrastructure layers.
- **Unit Testing**: Comprehensive test suite using JUnit 5 and AssertJ.
- **Maven**: Standard build and dependency management.

## Getting Started / Empezando

### Prerequisites / Prerrequisitos

- Java 21 JDK
- Maven 3.x

### Build / Construcción

To build the project and run tests:
Para construir el proyecto y ejecutar los tests:

```bash
mvn clean install
```

### Execution / Ejecución

You can run the simulation using the provided main class. By default, it reads from `src/test/resources/ficheros_dato/cesped`.
Puedes ejecutar la simulación usando la clase principal. Por defecto, lee de `src/test/resources/ficheros_dato/cesped`.

```bash
mvn exec:java -Dexec.mainClass="mowitnow.App"
```

To specify a different input file (relative to the base path):
Para especificar un fichero de entrada diferente (relativo a la ruta base):

```bash
mvn exec:java -Dexec.mainClass="mowitnow.App" -Dexec.args="cesped_top_border"
```

## Input File Format / Formato del Fichero de Entrada

The input file should follow this format:
El fichero de entrada debe seguir este formato:

1.  **Lawn dimensions**: (Upper-right coordinates, e.g., `5 5`).
2.  **Mower position and orientation**: (`X Y O`, e.g., `1 2 N`).
3.  **Instructions**: (`A`, `L`, `R` sequence, e.g., `LALALALAA`).

Repeat 2 and 3 for each mower.

## Project Structure / Estructura del Proyecto

- `src/main/java/mowitnow/domain`: Core business logic (Mower, Lawn, Orientation, etc.).
- `src/main/java/mowitnow/application`: Use cases and services.
- `src/main/java/mowitnow/infrastructure`: External interfaces (File parsing).
- `src/test/java`: Unit and integration tests.
