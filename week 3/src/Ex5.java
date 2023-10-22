import java.util.Scanner;

class TreeNode5 {
    int data;
    TreeNode5[] children;

    public TreeNode5(int data) {
        this.data = data;
        this.children = new TreeNode5[10];
        for (int i = 0; i < 10; i++) {
            this.children[i] = null;
        }
    }
}
public class Ex5 {
    public static TreeNode5 createNode(int data) {
        return new TreeNode5(data);
    }

    public static TreeNode5 findNode(TreeNode5 root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }
        for (int i = 0; i < 10; i++) {
            TreeNode5 found = findNode(root.children[i], data);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public static void insertNode(TreeNode5 root, int u, int v) {
        TreeNode5 parent = findNode(root, v);
        if (parent == null || findNode(root, u) != null) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (parent.children[i] == null) {
                parent.children[i] = createNode(u);
                break;
            }
        }
    }

    public static void preOrder(TreeNode5 root) {
        if (root != null) {
            System.out.print(root.data + " ");
            for (int i = 0; i < 10; i++) {
                preOrder(root.children[i]);
            }
        }
    }

    public static void inOrder(TreeNode5 root) {
        if (root != null) {
            inOrder(root.children[0]);
            System.out.print(root.data + " ");
            for (int i = 1; i < 10; i++) {
                inOrder(root.children[i]);
            }
        }
    }

    public static void postOrder(TreeNode5 root) {
        if (root != null) {
            for (int i = 0; i < 10; i++) {
                postOrder(root.children[i]);
            }
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode5 root = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String cmd = scanner.next();
            if (cmd.equals("MakeRoot")) {
                int u = scanner.nextInt();
                root = createNode(u);
            } else if (cmd.equals("Insert")) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                insertNode(root, u, v);
            } else if (cmd.equals("PreOrder")) {
                preOrder(root);
                System.out.println();
            } else if (cmd.equals("InOrder")) {
                inOrder(root);
                System.out.println();
            } else if (cmd.equals("PostOrder")) {
                postOrder(root);
                System.out.println();
            } else if (cmd.equals("*")) {
                break;
            }
        }
    }
}