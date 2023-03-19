import java.util.ArrayList;

public class Heap {
    

    static ArrayList<Integer> heapify(ArrayList<Integer> arr, int index) {
        int left = (2*index) + 1;
        int right = (2*index) + 2;
        int large = index;        

        if (left <= arr.size()-1) {
            if (arr.get(left) > arr.get(large)) {
                large = left;
            }
        }

        if (right <= arr.size()-1) {
            if (arr.get(right) > arr.get(large)) {
                large = right;
            }
        }

        if (arr.get(large) != arr.get(index)) {
            int swap = arr.get(index);
            arr.set(index, arr.get(large));
            arr.set(large, swap);
            arr = heapify(arr, large);
        }

        if (index == 0) {
            return arr;
        }

        
        return heapify(arr, index-1);

        

    }

    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        int[] arr = {1, 2, 3, 1000, 4, 10, 25, 30, 40, 99};

        for (int i : arr) {
            arrL.add(i);
        }

        ArrayList<Integer> new_arr = heapify(arrL, (arrL.size()/2)-1);

        for (int i : new_arr) {
            System.out.println(i);
        }
        
    }
}
