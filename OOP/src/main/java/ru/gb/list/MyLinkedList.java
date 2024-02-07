package ru.gb.list;

import ru.gb.list.exception.MyListIndexOutOfBoundException;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {
    private int size;

    private Node head;

    private class Node {
        private E value;
        private Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void add(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(e, null);
        size += 1;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size += 1;
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        Node currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        for (E e : c) {
            if (head == null) {
                head = new Node(e, null);
                currentNode = head;
                continue;
            }
            currentNode.next = new Node(e, null);
            currentNode = currentNode.next;
        }

        size += c.size();
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);

        if (index == 0) {
            addFirst(e);
            return;
        }

        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(e, currentNode.next);
        size += 1;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);

        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node node = new Node(e, currentNode.next == null ? null : currentNode.next.next);
        if (size == 1) {
            head = node;
        } else {
            currentNode.next = node;
        }

        return currentNode.value;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    @Override
    public boolean remove(E e) {
        Node prevNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(e)) {
                if (prevNode == null) {
                    head = currentNode.next == null ? null : currentNode.next;
                } else {
                    prevNode.next = currentNode.next == null ? null : currentNode.next;
                }
                size -= 1;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(e)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                Node nextNode = currentNode;
                currentNode = currentNode.next;
                currentIndex += 1;

                return nextNode.value;
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyListIndexOutOfBoundException(String.format("The index: %d is outside the size of the array: %d", index, size));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> iterator = iterator();

        sb.append(this.getClass().getSimpleName()).append("= {");
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
