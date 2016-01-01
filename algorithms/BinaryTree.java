/**
 * BinaryTree
 * Created by Sean on 16/1/1.
 */
public class BinaryTree {

    Node root;

    /**
     * Build a binary search tree.
     * @param key Node.key
     * @param value Node.value
     */
    public void addNode (int key, String value) {
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
                        parent.leftChild =newNode;
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

    public Node findNode (int key) {
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

     class Node {

        int key;
        String value;

        Node leftChild;
        Node rightChild;

        Node (int key, String value) {
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
    }
}
