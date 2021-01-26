package ast.constructs;

public enum OPSYM {

    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDER("/"),
    LOWER_THAN("<"),
    LOWER_EQUALS("<="),
    UPPER_THAN(">"),
    UPPER_EQUALS(">="),
    EQUALS("=="),
    NOT_EQUALS("!="),
    AND("&&"),
    OR("||"),
    NOT("!");

    private final String value;

    OPSYM(String s) {
        this.value=s;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static OPSYM parseOP(String s){
        switch (s){
            case "+" -> {
                return OPSYM.PLUS;
            }
            case "-" -> {
                return OPSYM.MINUS;
            }
            case "*" -> {
                return OPSYM.TIMES;
            }
            case "/" -> {
                return OPSYM.DIVIDER;
            }
            case "==" -> {
                return OPSYM.EQUALS;
            }
            case "<" -> {
                return OPSYM.LOWER_THAN;
            }
            case ">" -> {
                return OPSYM.UPPER_THAN;
            }
            case "<=" -> {
                return OPSYM.LOWER_EQUALS;
            }
            case ">=" -> {
                return OPSYM.UPPER_EQUALS;
            }
            case "!=" -> {
                return OPSYM.NOT_EQUALS;
            }
            case "&&" -> {
                return OPSYM.AND;
            }
            case "||" -> {
                return OPSYM.OR;
            }
            case "!" -> {
                return OPSYM.NOT;
            }

        }
        return null;
    }

}
