package com.bridgelabz;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = next;
    }
}

class List<T> {
    private int len = 0;
    Node<T> head;

    List() {
        this.head = null;
    }

    void addNode(T data) {

        Node<T> temp = new Node<>(data);

        if (this.head == null) {
            head = temp;
        } else {

            Node<T> X = head;

            while (X.next != null) {
                X = X.next;
            }

            X.next = temp;
        }

        len++;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        len++;
    }

    public String toString() {

        String S = "{";

        Node<T> X = head;

        if (X == null) return S + "}";

        while (X.next != null) {
            S += String.valueOf(X.data) + "->";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + "}";
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
        len++;
    }

    public void insertNthPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position <= len && position >= 1) {
            if (position == 1) {
                insertFirst(data);
            } else {

                int nodeCounter = 1;
                Node temp = head;
                Node previous = null;
                while (nodeCounter != position) {
                    previous = temp;
                    temp = temp.next;
                    nodeCounter++;
                }
                previous.next = newNode;
                newNode.next = temp;
            }
            len++;
        } else {
            System.out.println("Invalid Position");
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List Is Empty");
        } else {
            Node temp = head;
            head = head.next;
            temp = null;
        }
        len--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List IS Empty");
        } else {
            Node temp = head;
            Node previous = null;
            while (temp.next != null) {
                previous = temp;
                temp = temp.next;
            }
            previous.next = null;
            temp = null;
        }
        len--;
    }

    public int search(T data) {

        if (head == null) {
            return -1;
        }

        int index = 0;
        Node<T> temp = head;

        while (temp != null) {


            if (temp.data == data) {
                return index;
            }

            index++;
            temp = temp.next;
        }

        return -1;
    }
    public int size(){
        Node temp = head;
        int counter = 1;
        while (temp.next != null){
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    public void deleteNthPosition(int position) {
        if (position <= len && position >= 1) {
            if (position == 1) {
                deleteFirst();
            } else {
                Node previous = null;
                Node temp = head;
                int nodeCounter = 1;
                while (nodeCounter != position) {
                    previous = temp;
                    temp = temp.next;
                    nodeCounter++;
                }
                previous.next = temp.next;
                temp = null;
            }
            len--;
        } else {
            System.out.println("Invalid Input");
        }
    }

}

public class LinkedList {
    public static void main(String[] args) {
        List<Integer> list1 = new List<Integer>();
        list1.addNode(56);
        list1.addNode(30);
        list1.addNode(40);
        list1.addNode(70);
        int data = 40;
        int ans = list1.search(data);

        if (ans == data) {
            System.out.println("Element not found in the Linked List");
        } else {
            System.out.println("Element found in the Linked List at index " + ans);
            System.out.println("size of list is "+list1.size());
            list1.deleteNthPosition(ans + 1);
            System.out.println("After delete:"+list1);
            System.out.println("after delete size "+list1.size());
        }
    }
}

