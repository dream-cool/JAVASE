package com.clt;

public class HashMap<K,V> {

    int size;

    Node<K,V>[] table;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    public HashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public V put(K key, V value){
        int index = key.hashCode() & DEFAULT_INITIAL_CAPACITY-1;
        if (table[index] == null){
            table[index] = new Node(key.hashCode(),key,value,null);
        } else {
            Node temp = table[index];
            while (temp != null){
                if (key.hashCode() == temp.hash){
                    if (key.equals(temp.key)){
                        V oldValue = (V) temp.value;
                        temp.value = value;
                        return oldValue;
                    }
                }
                if (temp.next != null){
                    temp = temp.next;
                } else {
                    break;
                }
            }
            temp.next = new Node(key.hashCode(),key,value,null);
        }
        size++;
        return value;
    }

    public V get(K key){
        int index = key.hashCode() & DEFAULT_INITIAL_CAPACITY-1;
        if (table[index] == null){
            return null;
        } else {
            Node temp = table[index];
            while (temp != null){
                if (key.hashCode() == temp.hash){
                    if (key.equals(temp.key)){
                        return (V) temp.value;
                    }
                }
                if (temp.next != null){
                    temp = temp.next;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public boolean remove (K key){
        int index = key.hashCode() & DEFAULT_INITIAL_CAPACITY-1;
        if (table[index] == null){
            return false;
        } else {
            Node temp = table[index];
            if (key.hashCode() == temp.hash) {
                if (temp.key.equals(key)) {
                    table[index] = temp.next;
                    size--;
                    return true;
                }
            }
            while (temp.next != null){
                if (key.hashCode() == temp.next.hash){
                    if (temp.key.equals(key)){
                        temp.next = temp.next.next;
                        size--;
                        return true;
                    }
                }
                temp = temp.next;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        if (size == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0 ; i < DEFAULT_INITIAL_CAPACITY ; i++){
            Node temp = table[i];
            while (temp != null){
                sb.append(temp.key);
                sb.append("=");
                sb.append(temp.value);
                sb.append(", ");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-2,'}');
        return String.valueOf(sb);
    }

    public int size(){
        return this.size;
    }
}
