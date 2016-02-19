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

    }

    @Test
    public void testHasSubTree() {
        Assert.assertTrue(binaryTree.hasSubtree(binaryTree.root, subBinaryTree.root));
        Assert.assertFalse(binaryTree.hasSubtree(binaryTree.root, subBinaryTree2.root));
        Assert.assertFalse(binaryTree.hasSubtree(binaryTree.root, null));
        Assert.assertFalse(binaryTree.hasSubtree(null, subBinaryTree.root));
        Assert.assertFalse(binaryTree.hasSubtree(null, null));
    }
}
