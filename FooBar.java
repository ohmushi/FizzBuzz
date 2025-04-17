
import java.util.List;

public class FooBar {

    List<RulesPool> rulesPool = List.of(
            new DividingRulesPool(List.of(isDivisible(3, "Foo"), isDivisible(5, "Bar"))),
            new ContainingRulesPool(List.of(contains(3, "Foo"), contains(5, "Bar")))
    );

    private Rule isDivisible(int n, String res) {
        return (i) -> i % n == 0 ? res : "";
    }

    private Rule contains(int n, String res) {
        return (i) -> String.valueOf(i).contains(String.valueOf(n)) ? res : "";
    }

    public static void main(String[] args) {
        var app = new FooBar();
        var sb = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            sb.append(app.fooBarFor(i));
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private String fooBarFor(int n) {
        var sb = new StringBuilder();
        for (var pool : this.rulesPool) {
            sb.append(pool.applyRulesFor(n));
        }

        return sb.isEmpty() ? String.valueOf(n) : sb.toString();
    }
}

@FunctionalInterface
interface Rule {

    String apply(Integer i);
}

interface RulesPool {

    String applyRulesFor(int n);
}

record DividingRulesPool(List<Rule> rules) implements RulesPool {

    @Override
    public String applyRulesFor(int n) {
        var sb = new StringBuilder();
        for (var rule : rules) {
            sb.append(rule.apply(n));
        }
        return sb.toString();
    }
}

record ContainingRulesPool(List<Rule> rules) implements RulesPool {

    @Override
    public String applyRulesFor(int n) {
        var sb = new StringBuilder();
        for (var c : String.valueOf(n).split("")) {
            for (var rule : rules) {
                sb.append(rule.apply(Integer.valueOf(c)));
            }
        }

        return sb.toString();
    }
}
