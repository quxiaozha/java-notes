package com.quxun.algorithms;

/**
 * Description:
 * Created by quxiaozha on 2018-9-26 15:19.
 */
public class Link<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode() {
            Link.this.retArr[Link.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

    }

    private Node root;
    private int count;
    private int foot;
    private Object[] retArr;

    public void add(E data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;

    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        this.foot = 0;
        this.retArr = new Object[this.count];
        this.root.toArrayNode();
        return this.retArr;
    }

    public static void main(String[] args) {
        Link<String> stringLink = new Link<>();
        stringLink.add("node1");
        stringLink.add("node2");
        stringLink.add("node3");
        stringLink.add("node4");
        stringLink.add("node5");

        System.out.println(stringLink.size());
        Object[] res = stringLink.toArray();
        for (Object obj:res) {
            System.out.println(obj);
        }
    }

}
