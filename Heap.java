import java.util.ArrayList;


public class Heap {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    String mode;

    Heap(ArrayList<Integer> val, String type) {
        arr = val;
        mode = type;
        arr = heapify(0);
    }

    Heap(int[] val, String type) {
        mode = type;
        for (int i : val) {
            arr.add(i);
        }
        arr = heapify(0);
    }

    protected void insert(int val) {
        arr.add(val);
        arr = heapify(0);

    }

    protected void delete(int index) {
        int last_index = arr.size() - 1;
        arr.set(index, arr.get(last_index));
        arr.remove(last_index);
        arr = heapify(0);
    }

    protected int peek() {
        return arr.get(0);
    }

    protected int extract() {
        int root = peek();
        delete(0);
        return root;
    }



    private ArrayList<Integer> heapRecur(int index) {
        int left = (2*index)+1;
        int right = (2*index)+2;
        int target = index;
        int indexL = arr.size()-1;

        if (left <= indexL) {
            if (mode == "min") {
                if (arr.get(left) < arr.get(target)) {
                    target = left;
                }

            } else {
                if (arr.get(left) > arr.get(target)) {
                    target = left;
                }
            } 
        }

        if (right <= indexL) {
            if (mode == "min") {
                if (arr.get(right) < arr.get(target)) {
                    target = right;
                }
            } else {
                if (arr.get(right) > arr.get(target)) {
                    target = right;
                }
            }
        }

        if (arr.get(index) != arr.get(target)) {

            int swap = arr.get(index);
            arr.set(index, arr.get(target));
            arr.set(target, swap);
        
            if ((index%2 == 0) && (index > 0)) {
                arr = heapRecur((index/2) - 1);
            } else if (index%2 != 0) {
                arr = heapRecur(index/2);
            }
            arr = heapRecur(target);
            
        } else {
            return arr;
        }
        return arr;
    }

    private ArrayList<Integer> heapify(int index) {
    
        if (index > (arr.size()/2)-1) {
            return arr;
        }
        if (mode == "min") {
            arr = heapRecur(index);
        } else {
            arr = heapRecur(index);
        }

        return heapify(index+1);
    }

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 10, 25, 30, 40, 1000, 5000};
        int [] arr = {3, 56, 89, 1, 34, 1000, 1, 23};

        Heap heap = new Heap(arr, "max");

        // heap.insert(666);
        // heap.insert(78);
        // heap.delete(5);
        // System.out.println(heap.peek());
        // System.out.println(heap.extract());

        for (int i : heap.arr) {
            System.out.println(i);
        }
    }
}
