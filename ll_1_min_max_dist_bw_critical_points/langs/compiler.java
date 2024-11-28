class Driver {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();  // Read the entire line of input
        scanner.close();

        String[] values = myString.split(" "); // Split the input into individual values
        Node head = createLinkedList(values);  // Create linked list from values

        // Printing the linked list to verify
        Solution sol = new Solution();
        int[] output = sol.solve(head);

        // Convert to String manually
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < output.length; i++) {
            sb.append(output[i]);  // Append each element
            if (i < output.length - 1) {
                sb.append(" ");   // Add comma and space between elements
            }
        }

        System.out.println(sb.toString());

    }

    // Method to create a linked list from a string array of numbers
    public static Node createLinkedList(String[] values) {
        if (values.length == 0) return null;  // Handle empty input

        Node head = new Node();               // Initialize head node
        head.val = Integer.parseInt(values[0]);  // Assign the first value
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node();
            newNode.val = Integer.parseInt(values[i]);
            current.next = newNode;  // Link current node to the new node
            current = newNode;       // Move to the new node
        }
        return head;  // Return the head of the list
    }
}

// Node class definition
class Node {
    int val;
    Node next;
}
