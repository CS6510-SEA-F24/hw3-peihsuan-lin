package edu.neu.khoury.cs6510.f24.peihsuanlin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

  @Test
  void testConstructorWithValue() {
    Node node = new Node(10);
    assertEquals(10, node.getValue());
    assertNull(node.getLeft());
    assertNull(node.getRight());
  }

  @Test
  void testConstructorWithChildren() {
    Node leftChild = new Node(5);
    Node rightChild = new Node(15);
    Node node = new Node(10, leftChild, rightChild);

    assertEquals(10, node.getValue());
    assertEquals(leftChild, node.getLeft());
    assertEquals(rightChild, node.getRight());
  }

  @Test
  void testEqualsSameValues() {
    Node leftChild1 = new Node(5);
    Node rightChild1 = new Node(15);
    Node node1 = new Node(10, leftChild1, rightChild1);

    Node leftChild2 = new Node(5);
    Node rightChild2 = new Node(15);
    Node node2 = new Node(10, leftChild2, rightChild2);

    assertEquals(node1, node2);
  }

  @Test
  void testEqualsDifferentValues() {
    Node node1 = new Node(10);
    Node node2 = new Node(20);

    assertNotEquals(node1, node2);
  }

  @Test
  void testEqualsNull() {
    Node node = new Node(10);
    assertNotEquals(node, null);
  }

  @Test
  void testEqualsDifferentClass() {
    Node node = new Node(10);
    String notANode = "Not a node";
    assertNotEquals(node, notANode);
  }

  @Test
  void testEqualsSameObject() {
    Node node = new Node(10);
    assertEquals(node, node);  // A node should be equal to itself
  }

  @Test
  void testHashCodeSameValues() {
    Node leftChild1 = new Node(5);
    Node rightChild1 = new Node(15);
    Node node1 = new Node(10, leftChild1, rightChild1);

    Node leftChild2 = new Node(5);
    Node rightChild2 = new Node(15);
    Node node2 = new Node(10, leftChild2, rightChild2);

    assertEquals(node1.hashCode(), node2.hashCode());
  }

  @Test
  void testHashCodeDifferentValues() {
    Node node1 = new Node(10);
    Node node2 = new Node(20);
    assertNotEquals(node1.hashCode(), node2.hashCode());
  }
}
