public class QuickSort {

    /**
     * TODO
     * @param begin The position of the first element in the sequence to be sorted.
     * @param end   The position that is one-past the last element in the sequence to be sorted.
     * @param <E>   The element type for the sequence.
     */
    public static <E extends Comparable<? super E>>
    void quicksort(Iterator<E> begin, Iterator<E> end) {
        if (begin.equals(end)) {
            return;
        } else {
            Iterator<E> pivot = partition(begin, end);
            quicksort(begin, pivot);
            pivot.advance();
            quicksort(pivot, end);
        }
    }

    public static <E extends Comparable<? super E>>
    Iterator<E> partition(Iterator<E> begin, Iterator<E> end) {
        Iterator<E> last = Algorithms.last(begin, end);
        E pivotValue = last.get();
        Iterator<E> L = begin.clone();
        Iterator<E> R = begin.clone();

        while (!R.equals(last)) {
            if (R.get().compareTo(pivotValue) <= 0) {
                if (!R.equals(L)) {
                    Algorithms.iter_swap(R, L);
                }
                L.advance();
            }
            R.advance();
        }

        if (!L.equals(last)) {
            Algorithms.iter_swap(L, last);
        }

        return L;
    }

}
