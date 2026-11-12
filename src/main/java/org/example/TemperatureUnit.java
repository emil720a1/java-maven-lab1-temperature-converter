package org.example;

public enum TemperatureUnit {
    CELSIUS("°C"),
    FAHRENHEIT("°F"),
    KELVIN("K");

    private final String symbol;

    TemperatureUnit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
