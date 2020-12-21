package xyz.kosmonaffft.ast;

public class Operator implements AstNode {

    private char sign;

    private AstNode left;

    private AstNode right;

    public Operator(char sign, AstNode left, AstNode right) {
        this.sign = sign;
        this.left = left;
        this.right = right;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public AstNode getLeft() {
        return left;
    }

    public void setLeft(AstNode left) {
        this.left = left;
    }

    public AstNode getRight() {
        return right;
    }

    public void setRight(AstNode right) {
        this.right = right;
    }
}
