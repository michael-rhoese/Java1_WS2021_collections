package de.fherfurt.offtopic.collections;

public class DoubleLinkedList {
  private Node first;
  private Node last;
  private int size;

  public DoubleLinkedList() {
    this.first = null;
    this.last = null;
    this.size = -1;
  }

  public int size(){
    return size + 1;
  }

  public int add(int value){
    Node next = new Node(value);

    if(size == -1) {
      // 1. Liste ist leer
      this.first = this.last = next;
    } else {
      // 2. Liste ist nicht
      next.setPrev(this.last);
      this.last.setNext(next);

      this.last = next;
    }

    size++;

    return size();
  }

  public int add(int value, int position){
    Node next = new Node(value);
    int usedPosition = position - 1;

    boolean isPositionGreaterThanSize = size < usedPosition;
    if(isPositionGreaterThanSize && size != -1){
      throw new IllegalArgumentException("Position must be less then or equal size");
    }

    if(size == -1) {
      // 1. Liste ist leer
      first = last = next;
    } else {
      // 2. Liste ist nicht
      Node current = first;
      for (int index = 0; index < usedPosition; ++index){
        current = current.getNext();
      }

      next.setPrev(current.getPrev());
      next.setNext(current);

      if(next.getPrev() != null){
        next.getPrev().setNext(next);
      }

      current.setPrev(next);
    }

    size++;

    return size();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    Node current = first;
    while (current != null){
      builder
        .append(current.getValue())
        .append(';');

      current = current.getNext();
    }

    return builder.toString();
  }
}
