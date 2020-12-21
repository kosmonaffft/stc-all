package xyz.kosmonaffft.ast;

public class Value implements AstNode {

    private double value;

    public Value(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
