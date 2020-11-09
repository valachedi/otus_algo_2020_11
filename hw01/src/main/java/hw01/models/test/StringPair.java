package hw01.models.test;

public class StringPair {
    private String stringIn;
    private String stringOut;


    public StringPair(String stringIn, String stringOut) {
        this.stringIn = stringIn;
        this.stringOut = stringOut;
    }


    public String getStringIn() {
        return stringIn;
    }


    public String getStringOut() {
        return stringOut;
    }


    public String toString() {
        return stringIn + " -> " + stringOut;
    }
}
