package university.innopolis.stc.visitor.calculator;

import university.innopolis.stc.visitor.ast.Function;
import university.innopolis.stc.visitor.ast.Operator;
import university.innopolis.stc.visitor.ast.Value;
import university.innopolis.stc.visitor.ast.Variable;
import university.innopolis.stc.visitor.ast.Visitor;

import java.util.stream.Collectors;

public class ToStringVisitor implements Visitor {

    private String result = "";

    @Override
    public void visit(Value value) {
        result = String.valueOf(value.getValue());
    }

    @Override
    public void visit(Variable variable) {
        result = variable.getName();
    }

    @Override
    public void visit(Operator operator) {
        ToStringVisitor leftVisitor = new ToStringVisitor();
        ToStringVisitor rightVisitor = new ToStringVisitor();
        operator.getLeft().accept(leftVisitor);
        operator.getRight().accept(rightVisitor);

        result = String.format(
                "(%s %s %s)",
                leftVisitor.result,
                operator.getSign(),
                rightVisitor.result
        );
    }

    @Override
    public void visit(Function function) {
        String args = function.getArguments().stream()
                .map(n -> {
                    ToStringVisitor v = new ToStringVisitor();
                    n.accept(v);
                    return v.result;
                })
                .collect(Collectors.joining(", "));
        result = String.format("%s(%s)", function.getName(), args);
    }

    public String getResult() {
        return result;
    }
}
