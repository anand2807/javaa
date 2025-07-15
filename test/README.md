# Java Test Suite

This directory contains JUnit tests for the Java classes in the `src` directory.

## Test Classes

1. **JAVAREFTest.java**: Tests for the `JAVAREF` class, focusing on:
   - Constructor behavior (revealing a bug where fields are not properly initialized)
   - `toString()` method
   - `rev()` method behavior with Integer objects

2. **JAVALISTTest.java**: Tests for the `JAVALIST` class, focusing on:
   - List creation with `Arrays.asList()`
   - HashSet behavior (removing duplicates)
   - TreeSet behavior (sorting and removing duplicates)
   - ConcurrentSkipListSet behavior (sorting and removing duplicates)
   - Main method output

3. **JAVALTest.java**: Tests for the `JAVAL` class, focusing on:
   - String interning behavior
   - String object comparison
   - String literal comparison
   - Main method output

4. **JAVAOVERLTest.java**: Tests for the `JAVAOVERL` and `JAVAOVERLSC` classes, focusing on:
   - Field access in base and subclasses
   - Method overriding
   - Polymorphic behavior (fields vs methods)
   - Main method output

## Running the Tests

To compile and run the tests:

```bash
# Compile all source and test files
javac -d build/classes -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/*.java test/java/*.java

# Run all tests
java -cp build/classes:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore JAVAREFTest JAVALISTTest JAVALTest JAVAOVERLTest
```

## Test Coverage

These tests cover:
- Basic functionality of all classes
- Edge cases like string interning and object comparison
- Polymorphic behavior in inheritance
- Output verification for main methods

## Known Issues

- The `JAVAREF` constructor has a bug: it uses `x = x` instead of `this.x = x`, which means the instance variable `x` is not being set properly.
- The `y` parameter in the `JAVAREF` constructor is not being used at all.
- The `rev` method in `JAVAREF` attempts to swap two Integer objects, but due to the immutability of Integer objects in Java, this won't work as expected.