package models;

public class KeywordToken extends Token {

    public KeywordToken(String value) {
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
        return "[Keyword: " + value + "]";
    }

    @Override
    public String getTokenClass() {
        return "Keyword";
    }
}
