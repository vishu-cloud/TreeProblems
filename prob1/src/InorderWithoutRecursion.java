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
public class InorderWithoutRecursion {
    public static void Recursiveinorder(Node root)
    {
        if(root == null)
            return;
        Recursiveinorder(root.left);
        System.out.print(root.val);
        Recursiveinorder(root.right);
    }
    public static void IterativeInorder(Node root)
    {
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while(curr!=null || !stk.isEmpty())
        {
            while(curr!=null)
            {
                stk.push(curr);
                curr = curr.left;
            }
                curr = stk.pop();
                System.out.print(curr.val);
            curr = curr.right;
        }
    }
    public static void main(String args[])
    {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.left = new Node(4);
    tree.right.right = new Node(5);
    Recursiveinorder(tree);
        System.out.println();
        IterativeInorder(tree);
    }
}
