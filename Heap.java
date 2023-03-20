import java.util.ArrayList;


public class Heap {
    ArrayList<Integer> arr = new ArrayList<Integer>();

    Heap(ArrayList<Integer> val) {
        arr = val;
        arr = heapify(0);
    }

    Heap(int[] val) {
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



    private ArrayList<Integer> maxheapify(int index) {
        int left = (2*index)+1;
        int right = (2*index)+2;
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

        if (arr.get(index) != arr.get(large)) {
            int swap = arr.get(index);
            arr.set(index, arr.get(large));
            arr.set(large, swap);
        
            if ((index%2 == 0) && (index > 0)) {
                arr = maxheapify((index/2) - 1);
            } else {
                arr = maxheapify(index/2);
            }
            arr = maxheapify(large);
        } else {
            return arr;
        }
        return arr;
    }

    private ArrayList<Integer> heapify(int index) {
    
        if (index > (arr.size()/2)-1) {
            return arr;
        }

        arr = maxheapify(index);

        return heapify(index+1);
    }

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 10, 25, 30, 40, 1000, 5000};
        int [] arr = {3, 56, 89, 1, 34, 1000, 1, 23};

        Heap heap = new Heap(arr);

        heap.insert(666);
        heap.insert(78);
        heap.delete(5);
        System.out.println(heap.peek());
        System.out.println(heap.extract());

        for (int i : heap.arr) {
            System.out.println(i);
        }
    }
}
