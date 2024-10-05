package edu.neu.khoury.cs6510.f24.peihsuanlin;

import java.util.Objects;

/**
 * Represents a node in a binary tree.
 * Each node contains an integer and references to its left and right
 * child nodes, which are the roots of the left and right subtrees,
 * respectively.
 */
public class Node {
  /**
   * The integer value stored in this node.
   */
  private int value;

  /**
   * The left child of this node in the binary tree.
   * If there is no left child, this field is null.
   */
  private Node left;

  /**
   * The right child of this node in the binary tree.
   * If there is no right child, this field is null.
   */
  private Node right;

  /**
   * Constructs a leaf node with the given value.
   *
   * @param val the value to be stored in the node
   */
  public Node(final int val) {
    this.value = val;
  }

  /**
   * Constructs a node with the given value and children.
   *
   * @param val       the value to be stored in the node
   * @param leftNode  the left child node
   * @param rightNode the right child node
   */
  public Node(final int val, final Node leftNode, final Node rightNode) {
    this.value = val;
    this.left = leftNode;
    this.right = rightNode;
  }

  /**
   * Sets the left child node.
   *
   * @param leftNode the left child node
   */
  public void setLeft(final Node leftNode) {
    this.left = leftNode;
  }

  /**
   * Sets the right child node.
   *
   * @param rightNode the right child node
   */
  public void setRight(final Node rightNode) {
    this.right = rightNode;
  }

  /**
   * Gets the value of the node.
   *
   * @return the value of the node
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Gets the left child node.
   *
   * @return the left child node
   */
  public Node getLeft() {
    return this.left;
  }

  /**
   * Gets the right child node.
   *
   * @return the right child node
   */
  public Node getRight() {
    return this.right;
  }

  /**
   * Checks equality between this node and another object. Two nodes are
   * equal if they have the same value and their left and right children
   * are equal.
   *
   * @param o the object to compare to
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return value == node.value
        && Objects.equals(left, node.left)
        && Objects.equals(right, node.right);
  }

  /**
   * Generates a hash code for this node. The hash code is based on the
   * value of the node and its left and right children.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, left, right);
  }
}
