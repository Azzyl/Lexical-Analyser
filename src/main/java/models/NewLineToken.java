package models;

public class NewLineToken extends Token {

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
        return "\n";
    }

    @Override
    public String getTokenClass() {
        return "NewLine";
    }
}
