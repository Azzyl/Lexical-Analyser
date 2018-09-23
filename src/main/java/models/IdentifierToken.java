package models;

public class IdentifierToken extends Token {

    public IdentifierToken(String value) {
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
        return "[Identifier: " + value + "]";
    }

    @Override
    public String getTokenClass() {
        return "Identifier";
    }
}
