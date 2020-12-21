package university.innopolis.stc.visitor.calculator;

import org.junit.jupiter.api.Test;
import university.innopolis.stc.visitor.ast.AstNode;
import university.innopolis.stc.visitor.ast.Function;
import university.innopolis.stc.visitor.ast.Operator;
import university.innopolis.stc.visitor.ast.Value;
import university.innopolis.stc.visitor.ast.Variable;

import java.util.HashMap;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @Test
    void calculate() {
        // (x^2 + 10*x - 157) / (sin(x) + cos(y))
        AstNode l = new Operator(
                '-',
                new Operator(
                        '+',
                        new Operator('^', new Variable("x"), new Value(2.0)),
                        new Operator('*', new Value(10.0), new Variable("x"))
                ),
                new Value(157.0)
        );

        AstNode r = new Operator(
                '+',
                new Function("sin", singletonList(new Variable("x"))),
                new Function("cos", singletonList(new Variable("y")))
        );
        AstNode expression = new Operator('/', l, r);

        final double result = Calculator.calculate(expression, new HashMap<String, Double>() {{
            put("x", 10.0);
            put("y", -5.0);
        }});

        assertTrue(result - (-165.156619577) < 0.001);

        ToStringVisitor toStringVisitor = new ToStringVisitor();
        expression.accept(toStringVisitor);
        System.out.println(toStringVisitor.getResult());
    }
}
