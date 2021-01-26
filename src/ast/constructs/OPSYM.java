package ast.constructs;

public enum OPSYM {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDER("/"), EQUALS("=="), LOWER_THAN("<"), UPPER_THAN(">"), IF("if");

    private final String value;

    OPSYM(String s) {
        this.value=s;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
