package models;

public class OperatorToken extends Token {

    public OperatorToken(String value) {
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
        return "[Operator: " + value + "]";
    }

    @Override
    public String getTokenClass() {
        return "Operator";
    }
}
