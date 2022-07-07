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

        if (X == null)
            return S + "}";

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

}

public class LinkedList {
    public static void main(String[] args) {
        List<Integer> list1 = new List<Integer>();
        list1.addNode(56);
        list1.addNode(70);
        list1.insertNthPosition(30,2);
        System.out.println("Linkedlist is: " + list1);
    }
}
