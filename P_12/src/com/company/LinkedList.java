package com.company;

public class LinkedList implements List {
    Node head;
    int count;

    public LinkedList() {
        count = 0;
        head = null;
    }

    @Override
    public void add(String elem) {
        if (head == null) {
            Node node = new Node(elem, null);
            head = node;
        } else {
            Node nextNode = head;
            while (nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
            }
            Node newNode = new Node(elem, null);
            nextNode.setNext(newNode);
        }
        count++;
    }

    @Override
    public Node remove(int index) {
        if (index >= 0 & index < count) {
            int j = 0;
            Node node = head;
            while (j < index) {
                node = node.getNext();
                j++;
            }
            node.setNext(null);
            return node.getNext();
        } else {
            throw new IndexOutOfBoundsException("There's no element with index = " + index);
        }
    }

    @Override
    public String get(int index) {
        if (index >= 0 & index < count) {
            int j = 0;
            Node node = head;
            while (j < index) {
                node = node.getNext();
                j++;
            }
            return node.getValue();
        } else {
            throw new IndexOutOfBoundsException("There's no element with index = " + index);
        }
    }

    private class Node {
        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
