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

public class InorderSuccessor  {
    public static void call(Node root,Node find,Node[] index)
    {
        if(root == null)
            return;
        call(root.right,find,index);
        if(root == find) {
            index[0] = index[1];
            return;
        }
        index[1] = root;
        call(root.left,find,index);
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
        Node index[]= new Node[2];
        call(tree,tree.right.right,index);
        if(index[0] == null)
            System.out.println(index[0]);
        else
        System.out.println(index[0].val);
    }
}
