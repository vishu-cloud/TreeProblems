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

public class sumOfInorderpresux {
    public static void call(Node root,ArrayList<Integer> arr,int[] index)
    {
        if(root == null)
            return;
        call(root.left,arr,index);
        if(index[0] == 0)
            root.val = arr.get(index[0]+1);
        else if(index[0] == arr.size()-1)
            root.val = arr.get(index[0]-1);
        else
        {
            root.val = arr.get(index[0]+1)+arr.get(index[0]-1);
        }
        index[0]++;
        call(root.right,arr,index);
    }
    public static void inorder(Node root,ArrayList<Integer> arr)
    {
        if(root ==null)
            return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
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
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(tree,arr);
        System.out.println(arr);
        int index[]= new int[1];
        call(tree,arr,index);
        ArrayList<Integer> x = new ArrayList<>();
        inorder(tree,x);
        System.out.println(x);
    }
}
