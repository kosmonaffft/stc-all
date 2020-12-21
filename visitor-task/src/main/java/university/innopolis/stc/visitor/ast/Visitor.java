package university.innopolis.stc.visitor.ast;

public interface Visitor {

    void visit(Value value);

    void visit(Variable variable);

    void visit(Operator operator);

    void visit(Function function);
}
