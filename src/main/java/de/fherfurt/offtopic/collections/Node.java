package de.fherfurt.offtopic.collections;

public class Node {
  private final int value;
  private Node prev;
  private Node next;

  public Node(int value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}
