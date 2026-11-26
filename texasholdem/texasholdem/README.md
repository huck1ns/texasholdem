# Texas Hold'em

## Requirements

- JDK 23 or newer
- Maven 3.9 or newer
- Internet access the first time you build, so Maven can download project dependencies

## Build and run from a terminal

Install JDK 23 or newer and Maven 3.9 or newer. Then clone the GitHub repository and enter the directory containing `pom.xml`:

```sh
git clone https://github.com/huck1ns/texasholdem.git
cd texasholdem/game
```

```sh
mvn clean javafx:run
```

The project targets Java 23 bytecode, so newer JDKs can run it while preserving Java 23 compatibility.
