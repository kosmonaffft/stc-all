package university.innopolis.stc.visitor.ast;

public interface AstNode {

    void accept(Visitor v);
}
