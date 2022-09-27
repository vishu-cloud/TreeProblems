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
    public static int path(Node root, ArrayList<Node> arr, Node dest)
    {
        if(root == dest)
            return 1;
        if(root.left!=null) {
            arr.add(root.left);
            int l = path(root.left, arr, dest);
            if (l == 1)
                return 1;
            arr.remove(arr.size()-1);
        }
        if(root.right!=null) {
            arr.add(root.right);
            int r = path(root.right, arr, dest);
            if (r == 1)
                return 1;
            arr.remove(arr.size()-1);
        }
        return 0;
    }
    public static void inorder(Node root)
    {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
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
        ArrayList<Node> arr = new ArrayList<>();
        arr.add(tree);
        int x = path(tree,arr,tree.left.left);
        inorder(tree);
        System.out.println();
        for(int i=0;i<arr.size()/2;i++)
        {
            int temp = arr.get(i).val;
            arr.get(i).val=arr.get(arr.size()-1-i).val;
            arr.get(arr.size()-1-i).val = temp;
        }
        inorder(tree);
        //Level(tree);
    }
}
