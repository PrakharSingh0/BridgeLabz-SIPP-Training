import java.util.*;

public class SymmetricDifference {
    public static <T> Set<T> getSymmetricDiff(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        Set<T> common = new HashSet<>(a);
        common.retainAll(b);
        result.removeAll(common);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Symmetric Difference: " + getSymmetricDiff(s1, s2));
    }
}