# Java Maven Lab 1 Temperature Converter

A console application for converting temperatures between Celsius, Fahrenheit, and Kelvin.

The project was created as part of Laboratory Work No. 1 for the course “Java Software Construction”.

## Technologies

- Java 21
- Apache Maven
- Maven Shade Plugin
- UTF-8
- IntelliJ IDEA

## Features

- Conversion between °C, °F, and K
- Support for all conversion directions
- Repeated program execution through a console menu
- Exit command `0`
- Input validation without `try-catch`
- Handling of invalid numeric input
- Absolute zero validation
- Executable fat-JAR creation
- Running the application with `java -jar`

## Supported Units

| Symbol | Unit |
|---|---|
| °C | Celsius |
| °F | Fahrenheit |
| K | Kelvin |

## Project Structure

```text
src/
└── main/
    └── java/
        └── ua/
            └── edu/
                └── duikt/
                    └── lab1/
                        ├── Main.java
                        ├── TemperatureUnit.java
                        └── TemperatureConverter.java
Conversion Formulas
°C → °F: °C × 9 / 5 + 32
°F → °C: (°F − 32) × 5 / 9
°C → K:  °C + 273.15
K → °C:  K − 273.15
°F → K:  (°F − 32) × 5 / 9 + 273.15
K → °F:  (K − 273.15) × 9 / 5 + 32
Input Validation
The application uses the following methods to validate user input:
scanner.hasNextInt()
scanner.hasNextDouble()
The try-catch mechanism is not used for numeric input validation.

The application handles:
- Text entered instead of a number
- Invalid menu options
- Temperatures below absolute zero
- Invalid temperature units
Building the Project
To clean previous build results and create a JAR file, run:
mvn clean package
A successful build ends with:
BUILD SUCCESS
Running the Fat-JAR
After building the project, run:
java -jar target/converter.jar
If the JAR file has a different name, check the contents of the target directory:
ls target
Example
=== Temperature Converter ===

1) Celsius °C
2) Fahrenheit °F
3) Kelvin K

Select the source unit or enter 0 to exit: 1
Enter the value: 100

Select the target unit: 2

100.00 °C = 212.00 °F
Example of invalid input:
Enter the value: abc
Error: please enter a number.
Example of absolute zero validation:
Enter the value: -5
Error: temperature cannot be below absolute zero.
Author
Oleh Bondarenko
Group: TCR-31
Repository
https://github.com/emil720a1/java-maven-lab1-temperature-converter
