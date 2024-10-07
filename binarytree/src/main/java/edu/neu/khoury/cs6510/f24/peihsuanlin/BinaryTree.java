package edu.neu.khoury.cs6510.f24.peihsuanlin;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of a binary search tree (BST).
 */
public class BinaryTree implements BinaryTreeInterface {
  /**
   * The root node of the binary tree.
   */
  private Node root;

  /**
   * Constructs a binary tree with a root node.
   *
   * @param rootNode the root node of the tree
   */
  public BinaryTree(final Node rootNode) {
    this.root = rootNode;
  }

  /**
   * Constructs a binary tree with an integer value as the root node.
   * @param rootValue the value of the root node
   */
  public BinaryTree(final int rootValue) {
    this.root = new Node(rootValue);
  }

  /**
   * Constructs an empty binary tree.
   */
  public BinaryTree() {
    this.root = null;
  }

  /**
   * Inserts a value into the tree, it will call the helper method to
   * recursively insert with binary search tree property.
   *
   * @param value the value to be inserted
   */
  @Override
  public void insert(final int value) {
    root = insert(root, value);
  }

  private Node insert(final Node current, final int value) {
    if (current == null) {
      return new Node(value);
    }
    if (value < current.getValue()) {
      current.setLeft(insert(current.getLeft(), value));
    } else if (value > current.getValue()) {
      current.setRight(insert(current.getRight(), value));
    }
    return current;
  }

  /**
   * Checks if the tree is a BST. It will call the helper method to
   * recursively check according to the property.
   *
   * @return true if the binary tree is a BST, false otherwise
   */
  @Override
  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(final Node node, final int min,
                                     final int max) {
    if (node == null) {
      return true;
    }
    if (node.getValue() <= min || node.getValue() >= max) {
      return false;
    }
    return isBinarySearchTree(node.getLeft(), min, node.getValue())
        && isBinarySearchTree(node.getRight(), node.getValue(), max);
  }

  /**
   * Gets the maximum depth of the binary tree. It will call the helper method
   * to recursively get the maximum depth of the binary tree.
   *
   * @return the maximum depth
   */
  @Override
  public int getMaxDepth() {
    return getMaxDepth(root);
  }

  private int getMaxDepth(final Node node) {
    if (node == null) {
      return 0;
    }
    int leftDepth = getMaxDepth(node.getLeft());
    int rightDepth = getMaxDepth(node.getRight());
    return Math.max(leftDepth, rightDepth) + 1;
  }

  /**
   * Finds the maximum value in the binary tree. It will call the helper method
   * to recursively find the maximum value in the tree.
   *
   * @return the maximum value
   */
  @Override
  public int findMaxValue() {
    return findMaxValue(root);
  }

  private int findMaxValue(final Node node) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }
    int maxValue = node.getValue();
    int leftMax = findMaxValue(node.getLeft());
    int rightMax = findMaxValue(node.getRight());
    if (leftMax > maxValue) {
      maxValue = leftMax;
    }
    if (rightMax > maxValue) {
      maxValue = rightMax;
    }
    return maxValue;
  }

  /**
   * Performs an inorder traversal of the tree.
   *
   * @return a list of values in inorder sequence
   */
  public List<Integer> inOrderTraversal() {
    List<Integer> result = new ArrayList<>();
    inOrderTraversal(root, result);
    return result;
  }

  private void inOrderTraversal(final Node node, final List<Integer> result) {
    if (node != null) {
      inOrderTraversal(node.getLeft(), result);
      result.add(node.getValue());
      inOrderTraversal(node.getRight(), result);
    }
  }
}
