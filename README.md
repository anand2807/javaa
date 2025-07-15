# Java Examples Repository

This repository contains various Java examples demonstrating different Java concepts and features.

## Contents

- **src/**: Contains Java source files demonstrating various concepts:
  - `JAVAL.java`: String comparison and interning
  - `JAVALIST.java`: Collections (List, HashSet, TreeSet, ConcurrentSkipListSet)
  - `JAVAOVERL.java` and `JAVAOVERLSC.java`: Method overriding and polymorphism
  - `JAVAREF.java`: Object references and parameter passing
  - `JAVATHREADMASTER.java` and `WORKER.java`: Multithreading

## Tests

The repository now includes JUnit tests to verify the functionality of the Java classes:

- **test/java/**: Contains test classes for the Java source files
- **test/README.md**: Detailed information about the tests and how to run them

## Running the Tests

To compile and run the tests:

```bash
# Compile all source and test files
javac -d build/classes -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/*.java test/java/*.java

# Run all tests
java -cp build/classes:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore JAVAREFTest JAVALISTTest JAVALTest JAVAOVERLTest
```

## Dependencies

- JUnit 4.13.2 (for testing)
- Hamcrest Core 1.3 (for JUnit assertions)
