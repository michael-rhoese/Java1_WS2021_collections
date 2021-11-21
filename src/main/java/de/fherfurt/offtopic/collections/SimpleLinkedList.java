package de.fherfurt.offtopic.collections;

public class SimpleLinkedList {
  private Node first;
  private int size;

  public SimpleLinkedList() {
    this.first = null;
    this.size = -1;
  }

  public int size(){
    return size + 1;
  }

  public int add(int value){

    Node next = new Node(value);

    if(size == -1){
      // 1. Add to empty list
      first = next;
    } else {
      // 2. Add to non-empty list
      Node current = first;
      while (current.getNext() != null){
        current = current.getNext();
      }

      current.setNext(next);
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
