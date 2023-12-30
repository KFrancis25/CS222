// DeclarationST class
public class DeclarationST implements SyntaxTree {
    private String variableName;
    private String variableType;

    public DeclarationST(String variableName, String variableType) {
        this.variableName = variableName;
        this.variableType = variableType;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getVariableType() {
        return variableType;
    }

    @Override
    public void execute() {
        // Perform execution for DeclarationST
        // This might involve adding a new variable to a symbol table, for example
    }
}