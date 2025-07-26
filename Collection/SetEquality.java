import java.util.*;

public class SetEquality {
    public static <T> boolean areEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Are sets equal? " + areEqual(s1, s2));
    }
}