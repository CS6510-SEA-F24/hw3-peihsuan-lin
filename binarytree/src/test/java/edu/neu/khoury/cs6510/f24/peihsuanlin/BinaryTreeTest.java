package edu.neu.khoury.cs6510.f24.peihsuanlin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

  @Test
  public void testInsertOrder() {
    // Initialize the tree with the first value (50 as root)
    BinaryTree tree = new BinaryTree(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);
    List<Integer> expectedOrder = Arrays.asList(20, 30, 40, 50, 60, 70, 80);
    assertEquals(expectedOrder, tree.inOrderTraversal());
  }

  @Test
  public void testInsertDuplicates() {
    // Initialize with 50 as root
    BinaryTree tree = new BinaryTree(50);
    tree.insert(50); // Duplicate insertion
    assertEquals(1, tree.inOrderTraversal().size()); // Assuming no duplicates allowed
  }

  @Test
  public void testIsBinarySearchTree() {
    // Initialize with the first element (50 as root)
    BinaryTree tree = new BinaryTree(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);
    assertTrue(tree.isBinarySearchTree());
  }

  @Test
  void testInvalidBSTTree() {
    // Manually create an invalid BST with incorrect left/right node values
    Node root = new Node(50);
    root.setLeft(new Node(60)); // Invalid: left node > root
    root.setRight(new Node(40)); // Invalid: right node < root
    BinaryTree invalidTree = new BinaryTree(root);

    assertFalse(invalidTree.isBinarySearchTree());
  }

  @Test
  void testValidEmptyTree() {
    // Test with an empty tree
    BinaryTree emptyTree = new BinaryTree();
    assertTrue(emptyTree.isBinarySearchTree());
  }

  @Test
  void testMaxDepthEmptyTree() {
    BinaryTree emptyTree = new BinaryTree();
    assertEquals(0, emptyTree.getMaxDepth());
  }

  @Test
  void testMaxDepthUnbalancedTree() {
    BinaryTree tree = new BinaryTree(50);
    tree.insert(40);
    tree.insert(30);
    tree.insert(20);
    tree.insert(10);
    assertEquals(5, tree.getMaxDepth());
  }

  @Test
  void testGetMaxDepth_BalancedTree() {
    BinaryTree tree = new BinaryTree(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);

    assertEquals(3, tree.getMaxDepth());
  }

  @Test
  void testFindMaxValue() {
    BinaryTree tree = new BinaryTree(50);
    tree.insert(70);
    tree.insert(30);
    tree.insert(110); // Max value
    tree.insert(20);
    assertEquals(110, tree.findMaxValue());
  }

  @Test
  void testFindMaxValueInLeftSubtree() {
    BinaryTree tree = new BinaryTree(50);
    tree.insert(70);
    tree.insert(40);
    tree.insert(90); // Max value in right subtree
    tree.insert(45);
    assertEquals(90, tree.findMaxValue());
    tree.insert(100); // New max value
    assertEquals(100, tree.findMaxValue());
  }

  @Test
  void testFindMaxValueEmptyTree() {
    BinaryTree emptyTree = new BinaryTree();
    assertEquals(Integer.MIN_VALUE, emptyTree.findMaxValue()); // Expecting default value for empty tree
  }
}