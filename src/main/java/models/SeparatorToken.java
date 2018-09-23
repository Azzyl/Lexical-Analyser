package models;

public class SeparatorToken extends Token {

    public SeparatorToken(String value) {
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
        return "[Separator: " + value + "]";
    }

    @Override
    public String getTokenClass() {
        return "Separator";
    }
}
