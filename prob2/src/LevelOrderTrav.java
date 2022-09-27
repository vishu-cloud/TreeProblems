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
public class LevelOrderTrav {

        public static void Level(Node root)
        {
            Queue<Node> q = new LinkedList<>();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
            q.add(root);
            while(!q.isEmpty())
            {
                ArrayList<Integer> temp = new ArrayList<>();
                int s = q.size();
                for(int i=0;i<s;i++) {
                    if (q.peek().left != null)
                        q.add(q.peek().left);
                    if (q.peek().right != null)
                        q.add(q.peek().right);
                    temp.add(q.peek().val);
                    q.poll();
                }
                arr.add(temp);
            }
            System.out.println(arr);
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
            Level(tree);
        }
}
