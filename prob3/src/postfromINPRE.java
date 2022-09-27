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

public class postfromINPRE {
    public static void call(Node root,int[] pre,int[] in,int[] preindex)
    {
        if(in.length == 0 ||pre.length<=preindex[0] )
            return;
        int x = pre[preindex[0]];
        int index = -1;
       for(int i=0;i<in.length;i++)
       {
           if(in[i] == x)
           {
               index = i;
               break;
           }
       }
       if(index == -1)
           return;
       int[] l = Arrays.copyOfRange(in,0,index);
       preindex[0]++;
       call(root,pre,l,preindex);
        int[] r = Arrays.copyOfRange(in,index,in.length);
        call(root,pre,r,preindex);
        System.out.print(x+" ");
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
        int pre[] = {36,26,21,11,24,31,46,41,56,51,66};
        int in[] = {11,21,24,26,31,36,41,46,51,56, 66};
        int index[] = new int[1];
        call(tree,pre,in,index);
    }


}
