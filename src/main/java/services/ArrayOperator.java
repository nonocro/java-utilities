package services;

public abstract class ArrayOperator {
    public enum SortDirection {
        ASC,
        DESC
    }

    /**
     * Sort the array according to the given direction
     *
     * @param array the array to sort
     * @param sortDirection the direction of sorting
     */
    public static void sort(int[] array, SortDirection sortDirection){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++){
                boolean needSwitch;
                switch (sortDirection) {
                    case ASC:
                        needSwitch = array[j] > array[j+1];
                        break;
                    default:
                    case DESC:
                        needSwitch = array[j] < array[j+1];
                }

                if(needSwitch){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
