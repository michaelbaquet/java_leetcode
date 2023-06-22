package old;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] unsorted = new int[31];

        for(int i = 0; i< unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * 31);
        }

        int[] unsortedCopy = Arrays.copyOf(unsorted,unsorted.length);

        Arrays.sort(unsortedCopy);
        mergeSort(unsorted, 0, unsorted.length - 1, new int[unsorted.length]);

        System.out.println(Arrays.toString(unsortedCopy));
        System.out.println(Arrays.toString(unsorted));
        System.out.println(Arrays.equals(unsortedCopy, unsorted));


    }

    public static void mergeSort(int[] array, int beg, int end, int[] emptyArray) {
        if(beg >= end) {
            return;
        }

        int mid = ((end - beg) / 2) + beg;

        mergeSort(array, beg, mid, emptyArray);
        mergeSort(array, mid + 1, end, emptyArray);
        mergeSorted(array, emptyArray, beg, end);

    }

    private static void mergeSorted(int[] array, int[] temp, int beg, int end) {
        int left = beg;
        int rightEnd = end;
        int leftEnd = ((end - beg) / 2) + beg;
        int right = leftEnd + 1;
        int index = left;

        while(left <= leftEnd && right <= rightEnd) {

            if(array[left] < array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        //COPY REMAINING FROM ONE OF THE ARRAYS
        while(left <= leftEnd) {
            temp[index] = array[left];
            left++;
            index++;
        }
        while(right <= rightEnd) {
            temp[index] = array[right];
            right++;
            index++;
        }

        //COPY FROM TEMP BACK TO ARRAY
        for(int i = beg; i <= end; i++) {
            array[i] = temp[i];
        }

    }


    public static void quicksortRandomPivot(int[] array, int startIndex, int endIndex) {

        if(endIndex < 0 || startIndex >= endIndex || startIndex >= array.length) {
            return;
        }

        int pivotIndex =(int) (Math.random() * (endIndex + 1 - startIndex) + startIndex);
        swap(array, pivotIndex, endIndex);
        int pivot = array[endIndex];


        int i = startIndex;
        int j = startIndex;

        while(j < endIndex) {

            if(array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
            j++;
        }

        swap(array, endIndex, i);

        quicksort(array, startIndex, i -1);
        quicksort(array, i + 1, endIndex);
    }

    public static void quicksort(int[] array, int startIndex, int endIndex) {

        if(endIndex < 0 || startIndex >= endIndex || startIndex >= array.length) {
            return;
        }

        int pivot = array[endIndex];

        int i = startIndex;
        int j = startIndex;

        while(j < endIndex) {

            if(array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
            j++;
        }

        swap(array, endIndex, i);

        quicksort(array, startIndex, i -1);
        quicksort(array, i + 1, endIndex);
    }

    private static void swap(int[] array, int iIndex, int jIndex) {
        int temp = array[iIndex];
        array[iIndex] = array[jIndex];
        array[jIndex] = temp;
    }

}
