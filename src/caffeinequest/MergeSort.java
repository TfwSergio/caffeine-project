package caffeinequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Stable, recursive merge sort: O(n log n) time and O(n) auxiliary space. */
public final class MergeSort {
    private MergeSort() { }

    /** Sort in place and return the number of comparator calls. No library sort. */
    public static <T> long sort(List<T> items, Comparator<? super T> order) {
        List<T> buffer = new ArrayList<>(items);
        return sortRange(items, buffer, order, 0, items.size());
    }

    // Each range is half-open: [start, end).
    private static <T> long sortRange(List<T> items, List<T> buffer,
            Comparator<? super T> order, int start, int end) {
        if (end - start < 2) {
            return 0;
        }
        int middle = start + (end - start) / 2;
        long comparisons = sortRange(items, buffer, order, start, middle)
                + sortRange(items, buffer, order, middle, end);

        return comparisons + merge(items, buffer, order, start, middle, end);
    }

    /** Both halves are already sorted: [start, middle) and [middle, end). */
    private static <T> long merge(List<T> items, List<T> buffer,
            Comparator<? super T> order, int start, int middle, int end) {
        int left = start;
        int right = middle;
        int destination = start;
        long comparisons = 0;

        // A: while both halves have items, pick the earlier one
        while (left < middle && right < end) {
            comparisons++;
            if (order.compare(items.get(right), items.get(left)) < 0) {
                buffer.set(destination++, items.get(right++));   // right is strictly smaller
            } else {
                buffer.set(destination++, items.get(left++));    // left is smaller OR equal (stable)
            }
        }

        // B: leftovers from the left half
        while (left < middle) {
            buffer.set(destination++, items.get(left++));
        }

        // C: leftovers from the right half
        while (right < end) {
            buffer.set(destination++, items.get(right++));
        }

        // D: copy the merged range back and return this merge's comparison count
        for (int i = start; i < end; i++) {
            items.set(i, buffer.get(i));
        }
        return comparisons;
    }
}