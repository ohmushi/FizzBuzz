
import java.util.List;
import java.util.function.Function;

public class FooBar {

    List<Function<Integer, String>> dividingRules = List.of(
            isDivisible(3, "Foo"),
            isDivisible(5, "Bar")
    );

    List<Function<Integer, String>> containingRules = List.of(
            contains(3, "Foo"),
            contains(5, "Bar")
    );

    private Function<Integer, String> isDivisible(int n, String res) {
        return (i) -> i % n == 0 ? res : "";
    }

    private Function<Integer, String> contains(int n, String res) {
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
        for (var rule : this.dividingRules) {
            sb.append(rule.apply(n));
        }

        for (var c : String.valueOf(n).split("")) {
            for (var rule : this.containingRules) {
                sb.append(rule.apply(Integer.valueOf(c)));
            }
        }

        return sb.isEmpty() ? String.valueOf(n) : sb.toString();
    }
}
