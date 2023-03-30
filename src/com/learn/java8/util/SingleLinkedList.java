package com.learn.java8.util;

public class SingleLinkedList<E> {

    private int size;
    private ListNode<E> first;

    private static class ListNode<E> {
        E item;
        ListNode<E> next;

        ListNode(E item, ListNode<E> next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(item).append("_");
            if (next != null) {
                sb.append(next.item);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E item) {
        return this.indexOf(item) != -1;
    }

    private int indexOf(E item) {
        ListNode<E> node = first;
        if (null != item) {
            for (int i = 0; i < size; i++) {
                if (item.equals(node.item)) return i;
                node = first.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (null == (node.item)) return i;
                node = first.next;
            }
        }
        return -1;
    }

    public ListNode<E> node(int index) {
        this.checkIndex4Remove(index);
        ListNode<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex4Remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("remove index: " + index + ", size: " + size);
        }
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        //添加节点,首先获取前一个节点
        this.checkIndex4Add(index);
        if (index == 0) {
            first = new ListNode<>(item, first);
        } else {
            ListNode<E> prev = node(index - 1);
            prev.next = new ListNode<>(item, prev.next);
        }
        size++;
    }

    private void checkIndex4Add(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("add index: " + index + ", size: " + size);
        }
    }

    public E remove(int index) {
        checkIndex4Remove(index);
        ListNode<E> oldNode = null;
        if (index == 0) {
            oldNode = first;
            first = first.next;
        }else {
            ListNode<E> node = node(index - 1);
            oldNode = node.next;
            node.next = oldNode.next;
        }
        size--;
        return oldNode.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(" , ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
