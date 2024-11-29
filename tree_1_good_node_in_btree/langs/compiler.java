class Driver {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();  // Read the entire line of input
        scanner.close();

        int[] values = myString.split(" "); // Split the input into individual values
        TreeNode root = buildTreeFromLevelOrder(values);  // Create linked list from values

        // Printing the linked list to verify
        Solution sol = new Solution();
        int output = sol.solve(root);

        System.out.println(output);

    }

    // Function to build the tree from level-order array
    public static TreeNode buildTreeFromLevelOrder(int[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;  // Index to traverse the array

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode currentNode = queue.poll();

            // Process left child
            if (i < arr.length && arr[i] != null) {
                currentNode.left = new TreeNode(arr[i]);
                queue.offer(currentNode.left);
            }
            i++;

            // Process right child
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new TreeNode(arr[i]);
                queue.offer(currentNode.right);
            }
            i++;
        }
        return root;
    }
}


//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}