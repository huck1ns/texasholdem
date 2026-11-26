# Texas Hold'em

## Requirements

- JDK 23 or newer
- Maven 3.9 or newer
- Internet access the first time you build, so Maven can download project dependencies

## Build and run from a terminal

Install JDK 23 or newer and Maven 3.9 or newer. Then clone the GitHub repository and enter the nested project directory. The Maven project is one level below the repository root:

```sh
git clone https://github.com/huck1ns/texasholdem.git
cd texasholdem/texasholdem
ls pom.xml
```

If you already cloned the repository and your terminal is at its root, run `cd texasholdem` instead. Confirm `ls pom.xml` shows the project file, then build and launch the game:

```sh
mvn clean javafx:run
```

The `javafx:run` goal starts the game by launching `gameView`; `clean` only removes generated build files. Maven downloads JavaFX and the other declared dependencies automatically, including the JavaFX libraries for your operating system. Internet access is needed on the first run.

The project targets Java 23 bytecode, so newer JDKs can run it while preserving Java 23 compatibility.
