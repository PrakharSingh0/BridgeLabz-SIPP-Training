import java.util.*;

public class SetOperations {
    public static <T> Set<T> getUnion(Set<T> a, Set<T> b) {
        Set<T> union = new HashSet<>(a);
        union.addAll(b);
        return union;
    }

    public static <T> Set<T> getIntersection(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Union: " + getUnion(s1, s2));
        System.out.println("Intersection: " + getIntersection(s1, s2));
    }
}