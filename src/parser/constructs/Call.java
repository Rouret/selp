package parser.constructs;

import parser.State;
import java.util.List;

public class Call extends Exp {

    private final String identifier;
    private final List<Exp> args;


    public Call(String callName, List<Exp> listExp) {
        this.identifier = callName;
        this.args = listExp;
    }

    @Override
    public int eval(State<Integer> stateVariables, State<FunDef> stateFunDef) {
        FunDef funDef=stateFunDef.lookup(this.identifier);

        State<Integer> localState = new State<>();
        for (int i = 0; i < this.args.size(); i++) {
            localState.bind(funDef.getHead().getArgs().get(i).getValue(),this.args.get(i).eval(stateVariables,stateFunDef));
        }
        //pas de variable global donc pas besoin de gerer stateVariables && localState
        return funDef.getBody().eval(localState,stateFunDef);
    }

    @Override
    public String toString() {
        return "Call("+this.identifier+")";
    }
}
