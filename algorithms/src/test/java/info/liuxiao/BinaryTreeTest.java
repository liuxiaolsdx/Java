package info.liuxiao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BinaryTreeTest
 * Created by Sean on 16/2/20.
 */
public class BinaryTreeTest {
    private BinaryTree binaryTree = new BinaryTree();
    private BinaryTree subBinaryTree = new BinaryTree();
    private BinaryTree subBinaryTree2 = new BinaryTree();

    private BinaryTree mirrorTestTree = new BinaryTree();

    @Before
    public void setUp() {
        binaryTree.addNode(30, "root");
        binaryTree.addNode(12, "java");
        binaryTree.addNode(15, "python");
        binaryTree.addNode(10, "c++");
        binaryTree.addNode(75, "javascript");
        binaryTree.addNode(85, "scala");

        subBinaryTree.addNode(12, "java");
        subBinaryTree.addNode(15, "python");
        subBinaryTree.addNode(10, "c++");

        subBinaryTree2.addNode(12, "java");
        subBinaryTree2.addNode(15, "python");
        subBinaryTree2.addNode(85, "scala");

        mirrorTestTree.addNode(8);
        mirrorTestTree.addNode(6);
        mirrorTestTree.addNode(10);
        mirrorTestTree.addNode(5);
        mirrorTestTree.addNode(7);
        mirrorTestTree.addNode(9);
        mirrorTestTree.addNode(11);

    }

    @Test
    public void testHasSubTree() {
        Assert.assertTrue(binaryTree.hasSubtree(binaryTree.root, subBinaryTree.root));
        Assert.assertFalse(binaryTree.hasSubtree(binaryTree.root, subBinaryTree2.root));
        Assert.assertFalse(binaryTree.hasSubtree(binaryTree.root, null));
        Assert.assertFalse(binaryTree.hasSubtree(null, subBinaryTree.root));
        Assert.assertFalse(binaryTree.hasSubtree(null, null));
    }

    @Test
    public void testMirrorRecursively() {
        mirrorTestTree.preorderTreeWalk(mirrorTestTree.root);//8 6 5 7 10 9 11
        mirrorTestTree.mirrorRecursively();
        System.out.println("镜像二叉树为:");
        mirrorTestTree.preorderTreeWalk(mirrorTestTree.root);//8 10 11 9 6 7 5
    }

    @Test
    public void testVerifySequenceOfBST() {
        int[] sequence1 = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = {5, 6, 7};
        int[] sequence3 = {7, 8, 9};
        int[] sequence4 = {5};
        int[] sequence5 = {7, 4, 6, 5};

        Assert.assertTrue(BinaryTree.VerifySequenceOfBST(sequence1));
        Assert.assertTrue(BinaryTree.VerifySequenceOfBST(sequence2));
        Assert.assertTrue(BinaryTree.VerifySequenceOfBST(sequence3));
        Assert.assertTrue(BinaryTree.VerifySequenceOfBST(sequence4));
        Assert.assertFalse(BinaryTree.VerifySequenceOfBST(sequence5));
    }

    @Test
    public void testFindPath() {
        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(12);
        tree.addNode(4);
        tree.addNode(7);
        BinaryTree tree2 = new BinaryTree();
        tree2.addNode(10);
        tree2.addNode(7);
        tree2.addNode(6);
        tree2.addNode(5);
        tree2.addNode(3);

        System.out.println("Find path 19");
        tree.findPath(19);//10 5 4
        System.out.println("Find path 22");
        tree.findPath(22);//10 5 7; 10 12
        System.out.println("Find path 23");
        tree.findPath(23);

        System.out.println("Find path 28");
        tree2.findPath(28);
    }
}
