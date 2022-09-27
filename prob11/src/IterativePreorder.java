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

public class IterativePreorder {
    public static void path(Node root)
    {
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty())
        {
            Node temp = stk.peek();
            stk.pop();
            System.out.print(temp.val+" ");
            if(temp.right!=null)
            stk.push(temp.right);
            if(temp.left!=null)
            stk.push(temp.left);
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
