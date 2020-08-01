package trees;

import com.sun.codemodel.internal.JForEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Tree {

    public static void main(String[] args) {

        TreeNode<String> book = new TreeNode<>("Index");

        TreeNode<String> ch1 = new TreeNode<>("Chapter 1");
        ch1.insert("Section 1.1");
        ch1.insert("Section 1.2");
        ch1.insert("Section 1.3");

        TreeNode<String> ch2 = new TreeNode<>("Chapter 2");
        ch2.insert("Section 2.1");

        TreeNode<String> ch3 = new TreeNode<>("Chapter 3");
        ch3.insert("Section 3.1");
        ch3.insert("Section 3.2");
        ch3.insert("Section 3.3");
        ch3.insert("Section 3.4");
        ch3.insert("Section 3.5");

        book.insert(ch1);
        book.insert(ch2);
        book.insert(ch3);

        book.printPreOrder();
    }


    
    static class TreeNode<T> {
        T key;
        Object value;
        //instead of left and right child in bst
        List<TreeNode<T>> children = new ArrayList<>();


        public TreeNode(T key) {
            this.key = key;
        }

        public TreeNode<T> insert(TreeNode<T> key) {
            this.children.add(key);
            return this;
        }

        public TreeNode<T> insert(T key) {
            return this.insert(new TreeNode<>(key));
        }

        public void levelOrder(TreeNode<T> root) {
            Queue<TreeNode<T>> ts = new LinkedBlockingQueue<>();
            ts.add(root);

            while (!ts.isEmpty()) {
                TreeNode<T> node = ts.poll();
                System.out.println(node);
                for(TreeNode<T> child : node.children) {
                    ts.add(child);
                }
            }
        }

        public void printPreOrder() {
            helper(this, 0);
        }

        public void helper(TreeNode<T> node, int level) {
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
            for (TreeNode<T> child: node.children) {
                helper(child, level + 1);
            }
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }


}
