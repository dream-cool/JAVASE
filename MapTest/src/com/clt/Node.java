package com.clt;

public class Node<K,V> {
    int hash;
    K key;
    V value;
    Node<K,V> next;

    public Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node() {
    }

    public Node(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }
}
