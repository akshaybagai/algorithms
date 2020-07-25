package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) {
        Heap.sort(Arrays.asList(5, 3, 45, 23, 20, 23,67,56,12));
    }
}

class Heap<E extends Comparable<E>> {

    static <E extends Comparable<E>> List<E> sort(Iterable<E> elements) {
        Heap<E> heap = of(elements);

        List<E> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            result.add(heap.pop());
        }

        return result;
    }

    private boolean isEmpty() {
        return elements.isEmpty();
    }

    static <E extends Comparable<E>> Heap<E> of(Iterable<E> elements) {
        Heap<E> result = new Heap<>();
        for (E element : elements) {
            result.add(element);
        }
        return result;
    }

    private List<E> elements = new ArrayList<>();

    void add(E e) {
        elements.add(e);
        int elementIndex = elements.size() -1;
        while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
            int parentIndex = parentIndex(elementIndex);
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
        }
        System.out.println(elements);
    }

    E pop() {
        E result = elements.get(0);

        int lastElementIndex = elements.size() -1;
        swap(0, lastElementIndex);
        elements.remove(lastElementIndex);

        int elementIndex =0;
        while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
            int smallerChildIndex = smallerChildIndex(elementIndex);
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }

        System.out.println(result);
        return result;
    }

    private boolean isLeaf(int elementIndex) {
        return !isValidIndex(leftChildIndex(elementIndex));
    }

    private int smallerChildIndex(int elementIndex) {
        int leftChildIndex = leftChildIndex(elementIndex);
        int rightChildIndex = rightChildIndex(elementIndex);

        if(!isValidIndex(rightChildIndex)) {
            return leftChildIndex;
        }

        if(elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0) {
            return leftChildIndex;
        }
        return rightChildIndex;
    }

    void swap(int index1, int index2) {
        E element1 = elementAt(index1);
        E element2 = elementAt(index2);
        elements.set(index1, element2);
        elements.set(index2, element1);
    }

    boolean isRoot(int index) {
        return index == 0;
    }

    private boolean isCorrectParent(int elementIndex) {
        return isCorrect(elementIndex, leftChildIndex(elementIndex)) && isCorrect(elementIndex, rightChildIndex(elementIndex));
    }

    boolean isCorrectChild(int index) {
        return isCorrect(parentIndex(index), index);
    }

    boolean isCorrect(int parentIndex, int childIndex) {
        if(!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
            return true;
        }
        return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
    }

    boolean isValidIndex(int index) {
        return index < elements.size();
    }

    E elementAt(int index) {
        return elements.get(index);
    }

    int parentIndex(int index) {
        return (index - 1)/2;
    }

    int leftChildIndex(int index) {
        return 2*index +1;
    }

    int rightChildIndex(int index) {
        return 2*index + 2;
    }
}
