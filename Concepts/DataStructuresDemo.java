package Concepts;

// DataStructuresDemo.java
import java.util.*;
import java.util.LinkedList;    // For Stack, Queue, and Linked List
import java.util.ArrayList;    // For MinHeap
import java.util.Collections;  // For swapping elements in MinHeap
import java.util.Hashtable;    // For HashTable
import java.util.NoSuchElementException; // For handling exceptions in MinHeap

public class DataStructuresDemo {

    // 1. Linked List Implementation
    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CustomLinkedList {
        private LinkedListNode head;

        public void add(int data) {
            if (head == null) {
                head = new LinkedListNode(data);
            } else {
                LinkedListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new LinkedListNode(data);
            }
        }

        public void printList() {
            LinkedListNode current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // 2. Tree Implementation (Binary Search Tree)
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    static class BinaryTree {
        private TreeNode root;

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private TreeNode insertRec(TreeNode root, int value) {
            if (root == null) {
                root = new TreeNode(value);
                return root;
            }
            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        public void inOrderTraversal() {
            inOrderRec(root);
        }

        private void inOrderRec(TreeNode root) {
            if (root != null) {
                inOrderRec(root.left);
                System.out.print(root.value + " ");
                inOrderRec(root.right);
            }
        }
    }

    // 3. Stack Implementation
    static class Stack {
        private LinkedList<Integer> stack;

        Stack() {
            stack = new LinkedList<>();
        }

        public void push(int value) {
            stack.addFirst(value);
        }

        public int pop() {
            return stack.removeFirst();
        }

        public int peek() {
            return stack.getFirst();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    // 4. Queue Implementation
    static class Queue {
        private LinkedList<Integer> queue;

        Queue() {
            queue = new LinkedList<>();
        }

        public void enqueue(int value) {
            queue.addLast(value);
        }

        public int dequeue() {
            return queue.removeFirst();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    // 5. Heap Implementation (Min Heap)
    static class MinHeap {
        private ArrayList<Integer> heap;

        MinHeap() {
            heap = new ArrayList<>();
        }

        public void add(int value) {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        public int remove() {
            if (heap.isEmpty()) throw new NoSuchElementException();
            int root = heap.get(0);
            int last = heap.remove(heap.size() - 1);
            if (!heap.isEmpty()) {
                heap.set(0, last);
                heapifyDown(0);
            }
            return root;
        }

        private void heapifyUp(int index) {
            int parent = (index - 1) / 2;
            if (index > 0 && heap.get(index) < heap.get(parent)) {
                Collections.swap(heap, index, parent);
                heapifyUp(parent);
            }
        }

        private void heapifyDown(int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest != index) {
                Collections.swap(heap, index, smallest);
                heapifyDown(smallest);
            }
        }
    }

    // 6. Vector (ArrayList) Usage
    public static void demonstrateArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("ArrayList: " + list);
    }

    // 7. Hash Table Implementation
    public static void demonstrateHashTable() {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "One");
        table.put(2, "Two");
        table.put(3, "Three");
        System.out.println("HashTable: " + table);
    }

    public static void main(String[] args) {
        // Linked List Demo
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        System.out.print("Linked List: ");
        customLinkedList.printList();

        // Binary Tree Demo
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        System.out.print("Binary Tree (In-order Traversal): ");
        tree.inOrderTraversal();
        System.out.println();

        // Stack Demo
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack Pop: " + stack.pop());

        // Queue Demo
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue Dequeue: " + queue.dequeue());

        // Min Heap Demo
        MinHeap heap = new MinHeap();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        System.out.println("Min Heap Remove: " + heap.remove());

        // ArrayList Demo
        demonstrateArrayList();

        // HashTable Demo
        demonstrateHashTable();
    }
}
