package services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOperatorTest {

    @Test
    void sortEmpty(){
        int[] array = {};

        ArrayOperator.sort(array, ArrayOperator.SortDirection.ASC);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void sortAsc() {
        int[] array = {8,5,-6,8,1,2,3,65,-9,5,32,1,-5,6,8};

        ArrayOperator.sort(array, ArrayOperator.SortDirection.ASC);
        for(int i = 1; i < array.length-1; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }

    @Test
    void sortDesc() {
        int[] array = {8,5,6,-8,1,2,3,-65,9,5,32,1,-5,6,8};

        ArrayOperator.sort(array, ArrayOperator.SortDirection.DESC);
        for(int i = 1; i < array.length-1; i++){
            assertTrue(array[i] >= array[i+1]);
        }
    }
}