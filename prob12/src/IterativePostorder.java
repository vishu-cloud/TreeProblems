import java.util.*;
class Node
{
    int val;
    Node left, right;
    public Node(int item)
    {
        val = item;
        left = right = null;
    }
}

public class IterativePostorder {
    public static void path(Node r)
    {
        if(r == null )
            return;
        //using 2 stacks
//        Stack<Node> stk2 = new Stack<>();
//        Stack<Node> stk1 = new Stack<>();
//        stk1.push(root);
//        while(!stk1.isEmpty())
//        {
//            Node temp = stk1.peek();
//            stk1.pop();
//            stk2.push(temp);
//            if(temp.left!=null)
//                stk1.push(temp.left);
//            if(temp.right!=null)
//                stk1.push(temp.right);
//        }

        //using 1 stack
        Stack<Node> stk1 = new Stack<>();
        Node root = null;
        int flag = 1;
        stk1.push(r);
        while(!stk1.isEmpty())
        {
            if(flag ==1)
            {
                root = stk1.pop();
                flag = 0;
            }
            while(root!=null)
            {
                if(root.right!=null)
                stk1.push(root.right);
                stk1.push(root);
                root = root.left;
            }
            root = stk1.peek();
            stk1.pop();
            if(!stk1.isEmpty() && stk1.peek() == root.right) {
                Node x = stk1.pop();
                stk1.push(root);
                root = x;
            }
            else {
                System.out.print(root.val + " ");
                root = null;
            }

        }
    }
    public static void main(String args[])
    {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        path(tree);
        //Level(tree);
    }
}

