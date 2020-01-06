package com;



public class LinkedList {

    private Node first;

    private Node last;

    private int size;

    public boolean add(Object element){
        if (first == null){
            Node temp = new Node(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node temp = new Node(null, null, element);
            last.next = temp;
            temp.prev = last;
            temp.next = null;
            last = temp;
            size++;
            return true;
        }
    }

    public boolean add (int  index, Object element){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return false;
        }
        if (index == 0 ){
            return this.addFirst(element);
        }
        if (index == size-1){
            return this.addLast(element);
        }
        int idx = 1;
        for (Node temp= first.next; temp!=null ; temp=temp.next ){
            if (index == idx) {
                Node node = new Node(null, null, element);
                node.prev = temp.prev;
                node.next = temp;
                temp.prev.next=node;
                temp.prev=node;
                size++;
                return true;
            }
            idx++;
        }
        return false;
    }

    public Object remove (Object element){
        if (element == null){
            System.out.println("不能为空");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            for (Node temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)) {
                        if (temp == first && temp == last){
                            first = last = null;
                            return temp.element;
                        }
                        if (temp == last){
                            last.prev.next = null;
                            last = last.prev;
                        } else if (temp == first){
                            first.next.prev=null;
                            first=first.next;
                        } else {
                            temp.next.prev = temp.prev;
                            temp.prev.next = temp.next;
                        }
                        size--;
                        return temp.element;
                    }
                }
            }
            System.out.println("链表中没有该对象");
        }
        return null;
    }

    public boolean set (int  index, Object element){
        if (index < 0 || index > size ){
            throw new ArrayIndexOutOfBoundsException("下标索引不正确");
        }
        if (first==null){
            System.out.println("链表为空");
            return false;
        } else {
            int idx = 0;
            for (Node temp= first; temp!=null ; temp=temp.next ){
                if (index == idx) {
                    temp.element=element;
                    return true;
                }
                idx++;
            }
        }
        return false;
    }

    public Object remove (int  index){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            int idx = 0;
            for (Node temp= first; temp!=null ; temp=temp.next ){
                if (index == idx) {
                    if (temp == last){
                        last.prev.next = null;
                        last = last.prev;
                    } else if (temp == first){
                        first.next.prev=null;
                        first=first.next;
                    } else {
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                    }
                    size--;
                    return temp.element;
                }
                idx++;
            }
        }
        return null;
    }

    public Object searchByIndex (int index){
        if (index < 0 || index > size ){
            System.out.println("下标索引不正确");
            return null;
        }
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            int idx = 0;
            for (Node temp= first; temp!=null ; temp=temp.next){
                if (idx == index){
                    return temp.element;
                }
                idx++;
            }
        }
        return null;
    }

    public int getIndex (Object element){
        if (first==null){
            System.out.println("链表为空");
            return -1;
        } else {
            int idx=0;
            for (Node temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)) {
                        return idx;
                    }
                }
                idx++;
            }
            System.out.println("链表中没有该对象");
        }
        return -1;
    }

    public boolean addFirst(Object element){
        if (first == null){
            Node temp = new Node(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node temp = new Node(null, null, element);
            first.prev = temp;
            temp.next = first;
            first = temp;
            size++;
            return true;
        }
    }

    public boolean addLast(Object element){
        if (first == null){
            Node temp = new Node(null, null, element);
            temp.element = element;
            last = first = temp;
            size++;
            return true;
        } else {
            Node temp = new Node(null, null, element);
            last.next = temp;
            temp.prev = last;
            last = temp;
            size++;
            return true;
        }
    }

    public boolean addAll(LinkedList linkedList){
        if (!(linkedList instanceof LinkedList)){
            System.out.println("添加类型不匹配");
            return false;
        }
        if (linkedList.first==null){
            System.out.println("添加的列表为空");
            return false;
        }
        if (first == null){
            first = linkedList.first;
            size = linkedList.size;
            return true;
        } else {
            last.next = linkedList.first;
            linkedList.first.prev = last;
            last = linkedList.last;
            size=size+linkedList.size;
            return true;
        }
    }

    public Object removeFirst (){
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            Node temp = first;
            first.next.prev=null;
            first=first.next;
            size--;
            return temp.element;
        }
    }

    public Object removeLast (){
        if (first==null){
            System.out.println("链表为空");
            return null;
        } else {
            Node temp = last;
            last.prev.next = null;
            last = last.prev;
            size--;
            return temp.element;
        }
    }

    public boolean contains(Object element){
        if (first == null){
            System.out.println("链表为空");
            return false;
        } else {
            for (Node temp= first; temp!=null ; temp=temp.next ){
                if (temp.element.hashCode() == element.hashCode()){
                    if (temp.element.equals(element)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public Object[] toArrays( ){
        if (first == null){
            System.out.println("链表为空");
            return null;
        } else {
            Object[] objects = new Object[size];
            int index = 0;
            for (Node temp = first ; temp != null ; temp = temp.next){
                objects[index] = temp.element;
                index++;
            }
            return objects;
        }
    }

    public void clear(){
        for (Node temp = first; temp!=null ; temp = temp.next ){
            temp.prev = null;
            temp.next = null;
            temp.element = null;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (first == null){
            return null;
        } else {
            sb.append("{");
            for (Node temp= first; temp!=null ; temp=temp.next ){
                String s =temp.element.toString();
                sb.append(s).append(", ");
            }
            sb.setCharAt(sb.length()-1,'}');
        }
        return String.valueOf(sb);
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
