package info.liuxiao;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree
 * Created by Sean on 16/1/1.
 */
public class BinaryTree {

    Node root;

    public void addNode(int key) {
        this.addNode(key, null);
    }

    /**
     * Build a binary search tree.
     *
     * @param key   Node.key
     * @param value Node.value
     */
    public void addNode(int key, String value) {
        //create a new Node and initialize it
        Node newNode = new Node(key, value);

        //if there is no root this becomes root
        if (null == root) {
            root = newNode;
        } else {
            /*
            set root as the Node we will start with
            when we traverse the tree
            */
            Node focusNode = root;

            //Future parent for our new Node
            Node parent;
            while (true) {

                //root is the first Node to traverse
                parent = focusNode;

                /*
                Check if the new node should go to the left side
                of the parent node
                 */
                if (key < focusNode.key) {

                    //Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    //If the Node is leaf node (no children)
                    if (null == focusNode) {
                        parent.leftChild = newNode;
                        return;//the Node has been added
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (null == focusNode) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    /**
     * preorder tree walk
     *
     * @param focusNode root of the tree
     */
    public void preorderTreeWalk(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            preorderTreeWalk(focusNode.leftChild);
            preorderTreeWalk(focusNode.rightChild);
        }
    }

    public void inorderTreeWalk(Node focusNode) {
        if (focusNode != null) {
            inorderTreeWalk(focusNode.leftChild);
            System.out.println(focusNode);
            inorderTreeWalk(focusNode.rightChild);
        }
    }

    public void postorederTreewalk(Node focusNode) {
        if (focusNode != null) {
            postorederTreewalk(focusNode.leftChild);
            postorederTreewalk(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        //start at the top of the tree
        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            //the node wasn't found
            if (null == focusNode) {
                return null;
            }
        }
        return focusNode;
    }

    /**
     * Input pre and in order traverse result, then reconstruct it.
     */
    @NotNull
    public void reconstruct(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder) {
            throw new NullPointerException("Arguments is null!");
        }

        if (preorder.length != inorder.length) {
            throw new RuntimeException("Length of arguments aren't accordance.");
        }

        root = reconstructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder      preorder array
     * @param startPreorder preorder array left index
     * @param endPreorder   preorder array right index
     * @param inorder       inorder array
     * @param startInorder  inorder array left index
     * @param endInorder    inorder array right index
     * @return the root node
     */
    private Node reconstructCore(int[] preorder, int startPreorder, int endPreorder,
                                 int[] inorder, int startInorder, int endInorder) {

        Node root = new Node(preorder[startPreorder]);
        root.leftChild = root.rightChild = null;

        if (startPreorder == endPreorder) {
            if (startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]) {
                return root;
            } else {
                throw new IllegalArgumentException("Invalid input!");
            }
        }

        int rootIndex = startInorder;//Define a variable to record the root Node

        //Find the root(the root value came from preorder array) at the inorder array
        //then the left part is the left children tree
        //and the right part is the right children tree
        while (rootIndex <= endInorder && inorder[rootIndex] != preorder[startPreorder]) {
            ++rootIndex;
        }

        //Check two array is matched
        if (rootIndex == endInorder+1) {
            throw new IllegalArgumentException("The two array are not matched.");
        }

        int leftTreeLength = rootIndex - startInorder;
        int leftPreoderEnd = startPreorder + leftTreeLength;

        //Construct the left tree
        if (leftTreeLength > 0) {
            //preoreder array decreased per recursion

            root.leftChild = reconstructCore(
                    preorder, startPreorder + 1, leftPreoderEnd,
                    inorder, startInorder, rootIndex - 1);
        }
        //Construct the right tree
        if (leftTreeLength < endPreorder - startPreorder) {
            root.rightChild = reconstructCore(
                    preorder, leftPreoderEnd + 1, endPreorder,
                    inorder, rootIndex + 1, endInorder);
        }
        return root;
    }

    /**
     * 题目18: 树的子结构
     * 输入两颗二叉树A和B,判断B是不是A的子结构.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 先要遍历此树,寻找和树B的根结点值一样的结点R
     * 然后判断以R为根结点的子树是否和树B具有一样的结构
     * @param root1 Tree A node
     * @param root2 Tree B node
     * @return true: Tree A has Tree B
     */
    public boolean hasSubtree(Node root1, Node root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            //第一步:在树中找到和subTree的根结点值一样的结点
            if (root1.key == root2.key) {
                result = hasSameTree(root1, root2);//第二步:判断以roo1为根结点的子树是不是包含和树B一样的结构
            }

            //再遍历此数的左右结点
            if (!result) {
                result = hasSubtree(root1.leftChild, root2);
            }
            if (!result) {
                result = hasSubtree(root1.rightChild, root2);
            }
        }

        return result;
    }

    private boolean hasSameTree(Node root1, Node root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.key != root2.key) {
            return false;
        }

        return hasSameTree(root1.leftChild, root2.leftChild) && hasSameTree(root1.rightChild, root2.rightChild);
    }

    /**
     * 题目19: 二叉树的镜像
     * 完成一个函数,输入一个二叉树,输出它的镜像.(根据照镜子的经验,得出它的镜像)
     */
    public BinaryTree mirrorRecursively() {
        mirrorRecursively(root);
        return this;
    }

    private void mirrorRecursively(Node node) {
        if (node == null) {
            return;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return;
        }

        Node temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;

        if (node.leftChild != null) {
            mirrorRecursively(node.leftChild);
        }
        if (node.rightChild != null) {
            mirrorRecursively(node.rightChild);
        }
    }

    /**
     * 题目23:从上往下打印二叉树
     * 从上往下打印出二叉树的每个结点,同一层的结点按照从左到右的顺序打印.
     */
    /**
     * 此题可用BFS考虑.
     */
    public void printFromTopToBottom() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            System.out.println(temp);
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
        }
    }

    /**
     * 题目24: 二叉搜索树的后序遍历序列
     * 输入一个整数数组,判断该数组是不是某二叉搜索树的后序遍历的结果.
     * 如果是则返回true,否则返回false.假设输入的数组的任意两个数字都不相同.
     */
    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return VerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }
    /**
     * 序列最后一位肯定是此树的根,序列前面分为两部分:左子树和右子树
     * @param sequence 判断的序列
     * @param left 左下标
     * @param right 右下标
     * @return true: yes型
     */
    private static boolean VerifySequenceOfBST(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }

        int root = sequence[right];

        //取出序列中小于根结点的数
        int index = left;
        while (sequence[index] < root) {
            index++;//index为右子树开始的下标
        }

        int j = index;
        for (; j < right; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        //判断包含左/右子树的数组是不是二叉树的后序遍历序列
         return VerifySequenceOfBST(sequence, left, index - 1) && VerifySequenceOfBST(sequence, index, right - 1);
    }

    /**
     * 结点类
     */
    class Node {

        int key;
        String value;

        Node leftChild;
        Node rightChild;

        Node(int key) {
            this(key, null);
        }

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return value + " has the key " + key;
        }
    }

    /*
     * Create a binary search tree
     *          30
     *    12          75
     *  10    15          85
     *
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(30, "root");
        tree.addNode(12, "java");
        tree.addNode(15, "python");
        tree.addNode(10, "c++");
        tree.addNode(75, "javascript");
        tree.addNode(85, "scala");

        System.out.println("\nPre-order:");
        tree.preorderTreeWalk(tree.root);
        System.out.println("\nIn-order:");
        tree.inorderTreeWalk(tree.root);
        System.out.println("\nPost-order:");
        tree.postorederTreewalk(tree.root);

        System.out.println("\nFind a node whit the key 10");
        System.out.println(tree.findNode(10));

        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] wrong = {4, 7, 2, 1, 5, 3, 8, 9};//6 -> 9
        BinaryTree tree2 = new BinaryTree();
        tree2.reconstruct(preorder, inorder);
        tree2.postorederTreewalk(tree2.root);//{7, 4, 2, 5, 8, 6, 3, 1}

        BinaryTree tree3 = new BinaryTree();
        try {
            tree2.reconstruct(preorder, wrong);
        } catch (IllegalArgumentException e) {
            System.out.println("Test unmatched arguments success!");
        }
        tree2.postorederTreewalk(tree3.root);

        System.out.println();
        System.out.println("printFromTopToBottom");
        tree.printFromTopToBottom();

    }
}
