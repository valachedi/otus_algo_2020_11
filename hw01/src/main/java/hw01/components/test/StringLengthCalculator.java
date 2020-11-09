package hw01.components.test;

public class StringLengthCalculator implements StringResultCalculator {
    public String calculate(String string) {
        return String.valueOf(string.length());
    }
}
