package trees;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(44);
        TreeNode.insert(root, 17);
        TreeNode.insert(root, 88);
        TreeNode.insert(root, 8);
        TreeNode.insert(root, 32);
        TreeNode.insert(root, 65);
        TreeNode.insert(root, 97);

//        System.out.println(TreeNode.max(root));
//        System.out.println(TreeNode.min(root));
//        System.out.println(TreeNode.successor(root, new TreeNode(32)));
        TreeNode.levelOrder(root);
    }

    static class TreeNode {
        int key;
        Object attribute;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return key == treeNode.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public static void dfs(TreeNode node) {
            System.out.println(node); //pre order
            if(node.left != null) {
                dfs(node.left);
            }
            System.out.println(node); //In order
            if(node.right != null) {
                dfs(node.right);
            }
            System.out.println(node); //post order
        }




        public static void levelOrder(TreeNode root) {
            Queue<TreeNode> treeNodes = new LinkedBlockingQueue<>();
            treeNodes.add(root);

            while (!treeNodes.isEmpty()) {
                TreeNode node = treeNodes.poll();
                System.out.println(node);
                if(node.left != null) {
                    treeNodes.add(node.left);
                }
                if(node.right != null) {
                    treeNodes.add(node.right);
                }
            }
        }

        public TreeNode delete(TreeNode root, int key) {
            TreeNode foundNode = search(root, key);
            // nothing removed from the root tree
            if(foundNode == null) return root;

            TreeNode previous = null;
            TreeNode current = root;
            while (current != null) {
                if (key == current.key) {
                    return current;
                } else if (key < current.key) {
                    previous = current;
                    current = current.left;
                } else {
                    previous = current;
                    current = current.right;
                }
            }
            //case 1: node is a leaf
            //this means the node is a
            if (current.left == null && current.right == null) {
                //means it was a one node tree
                if (previous == null) return null;
                if (current.key == previous.left.key) {
                    previous.left = null;
                }
                if (current.key == previous.right.key) {
                    previous.right = null;
                }
                return root; // as this remains the root
            }

            //case 2: node has exactly one child

            TreeNode child = null;
            if (current.left == null && current.right != null) {
                child = current.right;
            }
            if (current.left != null && current.right == null) {
                child = current.left;
            }
            //this means a child was found for the current element
            if(child != null) {
                //means it was a one node tree
                if (previous == null) {
                    root = child;
                }
                if(current.equals(previous.left)) {
                    previous.left = child;
                }
                if(current.equals(previous.left)) {
                    previous.right = child;
                }
                return root;
            }

            //case 3: node has two children
            if (current.left != null && current.right != null) {
                TreeNode successor = current.right;
                while (successor.left != null) {
                    previous = successor;
                    successor = successor.left;
                }
                current.key = successor.key;

                //successor does not have left child
                //this is same as case 2
                if(successor.equals(previous.left)) {
                    previous.left = successor.right;
                }else {
                    previous.right = successor.right;
                }
            }

            return root;


        }

        public static TreeNode successor(TreeNode root, TreeNode p) {
            if (root == null) return null;
            if(p.right != null) {
                return min(p.right);
            }
            else {
                //how do we look up if there is no pointer?
                //search from p starting from root
                //and keep the record of the parent from where
                //we took the last left turn
                TreeNode ancestor = null;
                TreeNode current = root;
                while (current.key != p.key) {
                    if (p.key < current.key) {
                        ancestor = current;
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
                return ancestor;
            }
        }

        public static TreeNode search(TreeNode root, int key) {
            TreeNode current = root;
            while (current != null) {
                if (key == current.key) {
                    return current;
                } else if (key < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return null;
        }

        public static TreeNode min(TreeNode root) {
            TreeNode min = root;

            while (min.left != null) {
                min = min.left;
            }
            return min;
        }

        public static TreeNode max(TreeNode root) {
            TreeNode min = root;

            while (min.right != null) {
                min = min.right;
            }
            return min;
        }

        public static TreeNode insert(TreeNode root, int key) {
            TreeNode newNode = new TreeNode(key);
            if (root == null) {
                return newNode;
            }
            TreeNode previous = null;
            TreeNode current = root;
            while (current != null) {
                if (key == current.key) {
                    previous = current; //or throw exception for duplicate
                    return current;
                } else if (key < current.key) {
                    previous = current;
                    current = current.left;
                } else {
                    previous = current;
                    current = current.right;
                }
            }
            if (key < previous.key) {
                previous.left = newNode;
            } else {
                previous.right = newNode;
            }
            return root;
        }
    }
}
