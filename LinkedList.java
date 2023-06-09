import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private int size;

    LinkedList() {
        size = 0;
    }

    //find list size

    protected int size() {
        return size;
    }

    //add methods

    protected void addLast(int val) {
        if (head == null) { 
            head = new Node(val);   
        } else {
            Node node = new Node(val);
            Node point = head;

            while (point != null) {
                if (point.pointer == null) {
                    point.pointer = node;
                    node.pointer = null;
                }
                point = point.pointer;
            }
        }
        size+=1;
    }

    protected void addFirst(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node node = new Node(val);
            node.pointer = head;
            head = node;
        }
        size+=1;
    }

    protected void add(int index, int val) {
        if (head == null) {
            head = new Node(val);
            size+=1;
        } else {
            Node node = searchIndex(index-1);
            
            if (node != null) {
                Node new_node = new Node(val);
                new_node.pointer = node.pointer;
                node.pointer = new_node;
                size+=1;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    protected void add(int val) {
        addLast(val);
    }

    //remove methods

    protected void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head.pointer == null) {
            head = null;
        } else {
            head = head.pointer;
        }
        size -= 1;
    }

    protected void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node tnode = searchIndex(index-1);
            if (tnode != null) {
                tnode.pointer = tnode.pointer.pointer;
                size -= 1;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    protected void removeLast() {
        remove(this.size - 1);
    }

    protected void clear() {
        head = null;
        size = 0;
    }


    //print all elements

    protected void traverse() {
        Node point = head;
        
        while (point != null) {
            System.out.println(point.data);
            point = point.pointer;
        }
    }
    

    //search method

    private Node searchIndex(int index) {
        int counter = 0;
        Node point = head;
        
        while (point != null) {
            if (counter == index) {
                
                return point;
            }
            point = point.pointer;
            counter++;
        }
        return null;
    }


    //get methods

    protected int get(int index) {
        Node node = searchIndex(index);
        if (node != null) {
            return node.data;
        } else {
            throw new NullPointerException();
        }
    }

    protected int getFirst() {
        return get(0);
    }

    protected int getLast() {
        return get(this.size - 1);
    }


    //set methods

    protected void set(int index, int val) {
        Node tnode = searchIndex(index);
        if (tnode != null) {
            tnode.data = val;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    

    //Node Class
    private class Node {
        int data;
        Node pointer;

        Node (int val) {
            data = val;
            pointer = null;  
        }
    }
}
