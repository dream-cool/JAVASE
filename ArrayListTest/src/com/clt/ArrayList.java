package com.clt;


public class ArrayList<E> {

    private Object[] objects = null;

    private int size;

    private final static int DEFAULT_CAPACITY = 10;

    private int capacity;

    public ArrayList() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        objects = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean set(int index, E object){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        objects[index] = object;

        return true;
    }

    public E get(int index){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) objects[index];
    }

    public boolean add(E object){
        objects[size] = object;
        size++;
        if ( size == this.objects.length ){
            Object[] temp = new Object[objects.length + (objects.length >> 1)];
            for (int i = 0 ; i < size ; i++){
                temp[i] = objects[i];
            }
            objects = temp;
        }
        return false;
    }

    public boolean add(int index, E object){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int idx = size;
        while (idx > index){
            objects[idx] = objects[--idx];
        }
        objects[index] = object;
        size++;
        if ( size == this.objects.length ){
            Object[] temp = new Object[objects.length + (objects.length >> 1)];
            for (int i = 0 ; i < size ; i++){
                temp[i] = objects[i];
            }
            objects = temp;
        }
        return true;
    }

    public E remove(E object){
        int index = 0;
        E temp = null;
        for (int i = 0 ; i < size ; i++){
            if (object == objects[i]){
                index = i;
                temp = (E) objects[index];
                while (index < size){
                    objects[index++] = objects[index];
                }
                size--;
            }
        }
        return temp;
    }

    public E remove(int index){
        if (index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        E temp = (E) objects[index];
        while (index < size){
            objects[index++] = objects[index];
        }
        size--;
        return temp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0 ; i < size ; i++){
            sb.append(objects[i]);
            sb.append(",");
        }
        sb.setCharAt(sb.length()-1,'}');
        return String.valueOf(sb);
    }
}
