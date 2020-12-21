package xyz.kosmonaffft.calculator;

import org.junit.jupiter.api.Test;
import xyz.kosmonaffft.ast.AstNode;
import xyz.kosmonaffft.ast.Function;
import xyz.kosmonaffft.ast.Operator;
import xyz.kosmonaffft.ast.Value;
import xyz.kosmonaffft.ast.Variable;

import java.util.Collections;
import java.util.HashMap;

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
                new Function("sin", Collections.singletonList(new Variable("x"))),
                new Function("cos", Collections.singletonList(new Variable("y")))
        );
        AstNode expression = new Operator('/', l, r);

        final double result = Calculator.calculate(expression, new HashMap<String, Double>() {{
            put("x", 10.0);
            put("y", -5.0);
        }});

        assertTrue(result - (-165.156619577) < 0.001);
    }
}