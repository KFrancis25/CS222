// AssignmentST class
public class AssignmentST implements SyntaxTree {
    private String variableName;
    private SyntaxTree value;

    public AssignmentST(String variableName, SyntaxTree value) {
        this.variableName = variableName;
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

    public SyntaxTree getValue() {
        return value;
    }

    @Override
    public void execute() {
        // Perform execution for AssignmentST
        // This might involve assigning a value to a variable in a symbol table, for example
    }
}
