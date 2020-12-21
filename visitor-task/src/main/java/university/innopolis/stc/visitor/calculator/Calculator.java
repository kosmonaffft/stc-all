package university.innopolis.stc.visitor.calculator;

import university.innopolis.stc.visitor.ast.AstNode;

import java.util.Map;

public class Calculator {

    public static double calculate(AstNode expression, Map<String, Double> variables) {
        CalculatorVisitor v = new CalculatorVisitor(variables);
        expression.accept(v);
        return v.getResult();
    }
}
