
import java.util.*;

class Node
{
    int val;
    Node left, right,next;
    public Node(int item)
    {
        val = item;
        left = right =next= null;
    }
}

public class PopulateInorderSuccesors {
    public static Node call(Node root)
    {
        if(root == null)
            return null;
       Node r =  call(root.right);
       if(r!=null)
           root.next = r;
        Node l =  call(root.left);
        return root;
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
        int index[]= new int[1];
        Node z = call(tree);
    }
}
