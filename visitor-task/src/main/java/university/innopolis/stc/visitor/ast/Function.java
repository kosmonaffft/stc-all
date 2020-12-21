package university.innopolis.stc.visitor.ast;

import java.util.Collection;

public class Function implements AstNode {

    private String name;

    private Collection<AstNode> arguments;

    public Function(String name, Collection<AstNode> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<AstNode> getArguments() {
        return arguments;
    }

    public void setArguments(Collection<AstNode> arguments) {
        this.arguments = arguments;
    }
}
