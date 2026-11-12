package org.example;

public class TemperatureConverter {
    private static final double ABSOLUTE_ZERO_CELSIUS = -273.15;

    public double convert(
            double value,
            TemperatureUnit from,
            TemperatureUnit to
    ) {
        if (from == to) {
            return value;
        }

        double celsius = toCelsium(value, from);
        return fromCelsius(celsius, to);
    }

    public boolean isValid(double value, TemperatureUnit unit) {
        if (unit == TemperatureUnit.KELVIN) {
            return value >= 0;
        }

        return value >= ABSOLUTE_ZERO_CELSIUS;
    }

    private double toCelsium(double value, TemperatureUnit unit) {
        return switch (unit) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value - 32) * 5 / 9;
            case KELVIN -> value - 273.15;
        };
    }

    private double fromCelsius(double celsius, TemperatureUnit unit) {
        return switch (unit) {
            case CELSIUS -> celsius;
            case FAHRENHEIT -> celsius * 9 / 5 + 32;
            case KELVIN -> celsius + 273.15;
        };
    }
}
