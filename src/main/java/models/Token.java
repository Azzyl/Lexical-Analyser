package models;

abstract public class Token {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTokenClass() {
        return "TokenClass";
    }
}
