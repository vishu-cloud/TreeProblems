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

public class nthnodeofInorder {
    public static void call(Node root,Node[] index,int x,int[] check)
    {
        if(root == null)
            return;
        call(root.left,index,x,check);
        check[0]++;
        if(check[0]==x)
            index[0]= root;
        call(root.right,index,x,check);
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
        Node index[]= new Node[1];
        int check[] = new int[1];
        call(tree,index,3,check);
        if(index[0] == null)
            System.out.println(index[0]);
        else
            System.out.println(index[0].val);
    }
}
