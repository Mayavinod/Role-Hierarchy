import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class NAryTree {
    public static class TreeNode{
        String val;
       public List<TreeNode> children = new LinkedList<>();

        TreeNode(String data){
            val = data;
        }

        TreeNode(String data,List<TreeNode> child){
            val = data;
            children = child;
        }
    }

    private static void printNAryTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                System.out.print(node.val + " ");
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
            //System.out.println();
        }
    }

    public static void main(String[] args) 
    {
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter root role name : ");
        String a=sc.nextLine();
        TreeNode root = new TreeNode(a);
        int b=0;
        while(b!=2){
            System.out.println("Operations : \n 1. Add Sub Role. \n2. Display Roles. ");
            b=sc.nextInt();
            int c=b;
            Scanner sa=new Scanner(System.in);
            switch(c)
           {
            case 1:
                System.out.println("Operation to be performed : 1 \nEnter sub role name :");
                String s=sa.nextLine();
                System.out.println("Enter reporting to role name :");
                String s2=sa.nextLine();
                    root.children.add(new TreeNode(s));
                break;
             
            case 2:
                System.out.println("Operation to be performed : 2");
                 printNAryTree(root);
                break;
           }
        
          }
    }
}
