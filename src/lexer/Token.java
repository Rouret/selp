package lexer;

public interface Token {
    // pros of using an interface (vs an abstract class): an enum can "implement it"
    // cons: it cannot be used to impose a redefinition of toString
}
