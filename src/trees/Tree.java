package trees;

import com.sun.codemodel.internal.JForEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Tree {

    public static void main(String[] args) {

        TreeNode<String, Integer> book = new TreeNode<>("Index");

        TreeNode<String, Integer> ch1 = new TreeNode<>("Chapter 1");
        ch1.insert("Section 1.1");
        ch1.insert("Section 1.2");
        ch1.insert("Section 1.3");

        TreeNode<String, Integer> ch2 = new TreeNode<>("Chapter 2");
        ch2.insert("Section 2.1");

        TreeNode<String, Integer> ch3 = new TreeNode<>("Chapter 3");
        ch3.insert("Section 3.1");
        ch3.insert("Section 3.2");
        ch3.insert("Section 3.3");
        ch3.insert("Section 3.4");
        ch3.insert("Section 3.5");

        book.insert(ch1);
        book.insert(ch2);
        book.insert(ch3);

        book.printPreOrder();

        TreeNode<String, Integer> root = new TreeNode<>("/", 0);

        TreeNode<String, Integer> etc = new TreeNode<>("etc", 0);
        etc.insert(new TreeNode<>("a", 5));
        etc.insert(new TreeNode<>("b", 50));
        etc.insert(new TreeNode<>("c", 3));

        TreeNode<String, Integer> trees = new TreeNode<>("trees", 0);
        trees.insert(new TreeNode<>("a", 2));
        trees.insert(new TreeNode<>("b", 1));
        trees.insert(new TreeNode<>("c", 4));
        
        root.insert(etc);
        root.insert(trees);

        System.out.println(TreeNode.sum(root));
    }


    
    static class TreeNode<T, V> {
        T key;
        V value;
        //instead of left and right child in bst
        List<TreeNode<T, V>> children = new ArrayList<>();


        public TreeNode(T key) {
            this.key = key;
        }

        public TreeNode(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public TreeNode<T,V> insert(TreeNode<T,V> key) {
            this.children.add(key);
            return this;
        }

        public TreeNode<T,V> insert(T key) {
            return this.insert(new TreeNode<>(key));
        }

        public void levelOrder(TreeNode<T,V> root) {
            Queue<TreeNode<T,V>> ts = new LinkedBlockingQueue<>();
            ts.add(root);

            while (!ts.isEmpty()) {
                TreeNode<T,V> node = ts.poll();
                System.out.println(node);
                for(TreeNode<T,V> child : node.children) {
                    ts.add(child);
                }
            }
        }

        public void printPreOrder() {
            helper(this, 0);
        }

        public void helper(TreeNode<T,V> node, int level) {
            if (node == null) return;
            int numberOfSpaces = level;
            //pre order + number of levels
            StringBuilder sb = new StringBuilder();
            while (numberOfSpaces > 0) {
                sb.append(" ");
                numberOfSpaces--;
            }
            sb.append(node);
            System.out.println(sb.toString());
            for (TreeNode<T,V> child: node.children) {
                helper(child, level + 1);
            }
        }

        public static <T> Integer sum(TreeNode<T,Integer> node) {
            if (node == null) return null;
            Integer d = node.value;
            for (TreeNode<T,Integer> child: node.children) {
                d += sum(child);
            }
            return d;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }


}
