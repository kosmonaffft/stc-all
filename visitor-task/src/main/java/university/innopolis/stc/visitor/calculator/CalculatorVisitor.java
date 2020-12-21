package university.innopolis.stc.visitor.calculator;

import university.innopolis.stc.visitor.ast.Function;
import university.innopolis.stc.visitor.ast.Operator;
import university.innopolis.stc.visitor.ast.Value;
import university.innopolis.stc.visitor.ast.Variable;
import university.innopolis.stc.visitor.ast.Visitor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculatorVisitor implements Visitor {

    private double result = 0.0;

    private final Map<String, Double> variables;

    public CalculatorVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }

    @Override
    public void visit(Value value) {
        result = value.getValue();
    }

    @Override
    public void visit(Variable variable) {
        result = variables.get(variable.getName());
    }

    @Override
    public void visit(Operator operator) {
        CalculatorVisitor leftVisitor = new CalculatorVisitor(variables);
        CalculatorVisitor rightVisitor = new CalculatorVisitor(variables);
        operator.getLeft().accept(leftVisitor);
        operator.getRight().accept(rightVisitor);

        switch (operator.getSign()) {
            case '+':
                result = leftVisitor.result + rightVisitor.result;
                return;
            case '-':
                result = leftVisitor.result - rightVisitor.result;
                return;
            case '*':
                result = leftVisitor.result * rightVisitor.result;
                return;
            case '/':
                result = leftVisitor.result / rightVisitor.result;
                return;
            case '^':
                result = Math.pow(leftVisitor.result, rightVisitor.result);
                return;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    @Override
    public void visit(Function function) {
        List<Double> doubles = function.getArguments().stream()
                .map(n -> {
                    CalculatorVisitor v = new CalculatorVisitor(variables);
                    n.accept(v);
                    return v.result;
                })
                .collect(Collectors.toList());
        switch (function.getName()) {
            case "sin":
                result = Math.sin(doubles.get(0));
                return;
            case "cos":
                result = Math.cos(doubles.get(0));
                return;
        }
    }

    public double getResult() {
        return result;
    }
}
