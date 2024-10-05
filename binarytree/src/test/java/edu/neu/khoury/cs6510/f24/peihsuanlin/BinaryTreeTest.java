package edu.neu.khoury.cs6510.f24.peihsuanlin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BinaryTreeTest {

  private BinaryTree tree;
  BinaryTree emptyTree;

  @BeforeEach
  void setUp() {
    tree = new BinaryTree(null);
    emptyTree = new BinaryTree(null);
  }

  @Test
  public void testInsertOrder() {
    tree.insert(50);
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
    tree.insert(50);
    tree.insert(50);
    assertEquals(1, tree.inOrderTraversal().size());
  }

  @Test
  public void testIsBinarySearchTree() {
    tree.insert(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);
    assertEquals(true, tree.isBinarySearchTree());
  }

  @Test
  void testInvalidBSTTree() {
    Node root = new Node(50);
    root.setLeft(new Node(60));
    root.setRight(new Node(40));
    BinaryTree invalidTree = new BinaryTree(root);
    assertFalse(invalidTree.isBinarySearchTree());
  }

  @Test
  void testValidEmptyTree() {
    assertEquals(true, emptyTree.isBinarySearchTree());
  }

  @Test
  void testMaxDepthEmptyTree() {
    assertEquals(0, emptyTree.getMaxDepth());
  }

  @Test
  void testMaxDepthUnbalancedTree() {
    tree.insert(50);
    tree.insert(40);
    tree.insert(30);
    tree.insert(20);
    tree.insert(10);
    assertEquals(5, tree.getMaxDepth());
  }

  @Test
  void testGetMaxDepth_BalancedTree() {
    tree.insert(50);
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
    tree.insert(50);
    tree.insert(70);
    tree.insert(30);
    tree.insert(110);
    tree.insert(20);
    assertEquals(110, tree.findMaxValue());
  }

  @Test
  void testFindMaxValueInLeftSubtree() {
    tree.insert(50);
    tree.insert(70);
    tree.insert(40);
    tree.insert(90);
    tree.insert(45);
    assertEquals(90, tree.findMaxValue());

    tree.insert(100);
    assertEquals(100, tree.findMaxValue());
  }

  @Test
  void testFindMaxValueEmptyTree() {
    assertEquals(Integer.MIN_VALUE, emptyTree.findMaxValue());
  }
}
