package models;

public class LiteralToken extends Token {

    public LiteralToken(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Literal: " + value + "]";
    }

    @Override
    public String getTokenClass() {
        return "Literal";
    }
}
