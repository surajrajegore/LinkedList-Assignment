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

    public String toString() {

        String S = "{";

        Node<T> X = head;

        if (X == null)
            return S + "}";

        while (X.next != null) {
            S += String.valueOf(X.data) + "->";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + "}";
    }
}

public class LinkedList {
    public static void main(String[] args) {
        List<Integer> list1 = new List<Integer>();
        list1.addNode(50);
        list1.addNode(30);
        list1.addNode(70);
        System.out.println("Linkedlist is: " + list1);
    }
}
