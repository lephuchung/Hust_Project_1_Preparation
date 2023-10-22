import java.util.Scanner;
class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
public class Ex7 {
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        Scanner scanner = new Scanner(System.in);
        String command;
        int key;

        while (true) {
            command = scanner.next();

            if (command.equals("#")) {
                break;
            }

            key = scanner.nextInt();

            if (command.equals("insert")) {
                root = insert(root, key);
            }
        }
        preOrderTraversal(root);
    }
}
