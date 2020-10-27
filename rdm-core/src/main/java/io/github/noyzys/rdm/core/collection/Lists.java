package io.github.noyzys.rdm.core.collection;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: NoyZys on 17:29, 27.10.2020
 **/
public final class Lists {

    /* from: https://github.com/panda-lang/panda/blob/master/panda-utilities/src/main/java/org/panda_lang/utilities/commons/collection/Lists.java */

    /**
     * Add element to the given collection and get added value as result
     *
     * @param list    the collection to use
     * @param element the element to add
     * @param <T>     type of element
     * @return the element to add
     */
    public static <T> T add(Collection<T> list, T element) {
        list.add(element);
        return element;
    }

    /**
     * Returns a view of the portion of the given list
     *
     * @param list       the list to use
     * @param startIndex low endpoint (inclusive) of the subList
     * @param <T>        type of list
     * @return a view of the specified range within this list
     */
    public static <T> List<T> subList(List<T> list, int startIndex) {
        return list.subList(startIndex, list.size());
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex exclusive.
     * The returned array list is independent collection and changes does not affect the original list.
     *
     * @param list       the list to use as source list
     * @param startIndex the start index
     * @param endIndex   the end index
     * @param <T>        type of list
     * @return a new list
     */
    public static <T> ArrayList<T> subList(List<T> list, int startIndex, int endIndex) {
        return new ArrayList<>(list.subList(startIndex, endIndex));
    }

    /**
     * Sort similar lists using the same comparator
     *
     * @param comparator  the comparator to use
     * @param collections the array of lists to sort
     * @param <T>         type of the lists
     */
    @SafeVarargs
    public static <T> void sort(Comparator<T> comparator, List<? extends T>... collections) {
        for (List<? extends T> collection : collections) {
            collection.sort(comparator);
        }
    }

    /**
     * Reverse the provided list and return its
     *
     * @param list the list to reverse
     * @param <T>  type of the list
     * @return the reversed list
     */
    public static <T> List<T> reverse(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    /**
     * Split list by the given delimiter
     *
     * @param list      the list to split
     * @param delimiter the object to use as delimiter
     * @param <T>       type of list
     * @return the array of lists
     */
    public static <T> List<T>[] split(List<T> list, T delimiter) {
        List<List<T>> elements = new ArrayList<>();
        int previousIndex = -1;

        for (int index = 0; index < list.size(); index++) {
            if (!list.get(index).equals(delimiter)) {
                continue;
            }

            elements.add(list.subList(++previousIndex, index));
            previousIndex = index;
        }

        if (previousIndex > -1) {
            elements.add(subList(list, ++previousIndex));
        }

        if (elements.isEmpty()) {
            elements.add(list);
        }

        //noinspection unchecked
        return elements.toArray(new List[0]);
    }

    /**
     * Create mutable list from varargs
     *
     * @param elements to add to the array
     * @param <T>      type of the list
     * @return created list
     */
    @SafeVarargs
    public static <T> List<T> mutableOf(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Get element of list at the given position without risk of {@link java.lang.ArrayIndexOutOfBoundsException}
     *
     * @param list  the list to process
     * @param index the index of element to get
     * @param <T>   type of the list
     * @return the element at the index position, null if the index is less than 0 or greater than the size of the specified list
     */
    public static <T> @Nullable T get(List<T> list, int index) {
        return index > -1 && index < list.size() ? list.get(index) : null;
    }
}
