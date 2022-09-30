import java.lang.reflect.Array;
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

public class DiagonalTraverse{
    public static void path(Node root,int slope,HashMap<Integer,ArrayList<Integer>> h)
    {
        if(root == null)
            return;
        if(!h.containsKey(slope))
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            h.put(slope,temp);
        }
        else{
            ArrayList<Integer> temp=h.get(slope);
            temp.add(root.val);
            h.put(slope,temp);
        }
        path(root.left,slope-1,h);
        path(root.right,slope,h);
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
        HashMap<Integer,ArrayList<Integer>> h= new HashMap<Integer,ArrayList<Integer>>();
        int slope = 0;
        path(tree,slope,h);
        System.out.println(h);
    }
}

