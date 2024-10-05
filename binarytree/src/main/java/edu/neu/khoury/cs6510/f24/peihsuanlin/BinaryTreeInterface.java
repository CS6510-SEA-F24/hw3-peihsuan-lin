package edu.neu.khoury.cs6510.f24.peihsuanlin;

/**
 * Interface defining the operations for a binary tree.
 * A binary tree is a tree data structure in which each node contains
 * an integer, a left child binary tree, and a right child binary tree.
 */
public interface BinaryTreeInterface {

  /**
   * Inserts a value into the binary tree.
   *
   * @param value the integer value to insert into the tree
   */
  void insert(int value);

  /**
   * Checks if the tree follows the binary search tree (BST) property.
   *
   * @return true if the tree is a valid binary search tree, false otherwise
   */
  boolean isBinarySearchTree();

  /**
   * Returns the maximum depth of the binary tree.
   *
   * @return the maximum depth of the tree
   */
  int getMaxDepth();

  /**
   * Finds and returns the maximum value stored in the binary tree.
   *
   * @return the maximum integer value in the tree
   */
  int findMaxValue();
}
