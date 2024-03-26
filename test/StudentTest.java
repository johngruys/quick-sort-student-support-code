import org.junit.jupiter.api.Test;
//import sequences.*;
import java.util.Arrays;
import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.ListIterator;


import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Test
    public void test() {
        testQuickSort();
        testSorted();
        testDuplicates();
    }

    @Test
    public void testQuickSort() {
        // Make list to sort
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i <= 100; i++) {
            list1.insert_front(i);
        }

        // Sorted List
        LinkedList<Integer> sorted_list1 = new LinkedList<>();
        for (int i = 100; i >= 0; i--) {
            sorted_list1.insert_front(i);
        }
//
//        LinkedList.ListIterator iterator = (LinkedList.ListIterator) list1.begin();
//        LinkedList.ListIterator end = (LinkedList.ListIterator) list1.end();

        QuickSort.quicksort(list1.begin(), list1.end());
        assertTrue(Algorithms.equal_sequences(list1, sorted_list1));

    }

    @Test
    public void testSorted() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= 100; i++) {
            list.insert_front(i);
        }

        QuickSort.quicksort(list.begin(), list.end());
        assertTrue(Algorithms.equal_sequences(list, list)); // Already sorted
    }

    @Test
    public void testDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> keyList = new LinkedList<>();

        // Insert duplicate elements
        for (int i = 0; i < 50; i++) {
            list.insert_front(5);
        }

        for (int i = 50; i <= 100; i++) {
            list.insert_front(i);
        }

        // Sorted List
        for (int i = 100; i >= 50; i--) {
            keyList.insert_front(i);
        }
        for (int i = 0; i < 50; i++) {
            keyList.insert_front(5);
        }

        QuickSort.quicksort(list.begin(), list.end());
        assertTrue(Algorithms.equal_sequences(list, keyList));
    }



//    public boolean intIsSorted(LinkedList.ListIterator iterator) {
//        boolean sorted = true;
//        int num = 0;
//        if (iterator != null) {
//            num = (Integer) iterator.get();
//        }
//        iterator.advance();
//        if (iterator != null) {
//            while (iterator != null) {
//                int next = (Integer) iterator.get();
//                if (!(next > num)) {
//                    sorted = false;
//                }
//                num = next;
//                iterator.advance();
//            }
//        }
//        return sorted;
//    }

}
