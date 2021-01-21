package parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// a state can be seen as a function of type Identifier -> Value
public class State<Value> {
    // the function is implemented as a map
    private Map<String, Value> map = new HashMap<>();

    // look up the value of an identifier
    // throws an (unchecked) exception if the identifier does not exist
    public Value lookup(String name) {
        Value option = map.get(name);
        if (option != null)
            return option;
        else
            throw new RuntimeException("unknown identifier: " + name);
    }

    // binds a the value to an identifier
    // throws an (unchecked) exception if the identifier is already bound
    public void bind(String name, Value value) {
        if (map.containsKey(name))
            throw new RuntimeException("redefining identifier: " + name);
        else
            map.put(name, value);
    }

    // generalizes bind to a list of values and a list of identifiers
    // useful in function calls
    // throws an (unchecked) exception if the sizes of the arguments differ
    public void bindAll(List<String> names, List<Value> values) {
        if (names.size() == values.size())
            for (int i = 0; i < names.size(); i++)
                bind(names.get(i), values.get(i));
        else
            throw new IllegalArgumentException("bindAll incompatible argument lengths: " + names + " and " + values);
    }
    @Override public String toString() {
        return map.toString();
    }
}
