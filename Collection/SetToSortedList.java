import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sorted = convertAndSort(hashSet);
        System.out.println("Sorted List: " + sorted);
    }
}