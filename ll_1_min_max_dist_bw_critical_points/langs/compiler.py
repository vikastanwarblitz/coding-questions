class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def solve(self, head):
        # Example solve method logic: collect values into a list
        result = []
        current = head
        while current is not None:
            result.append(current.val)
            current = current.next
        return result

def create_linked_list(values):
    if len(values) == 0:
        return None
    
    head = Node(int(values[0]))  # Initialize head node
    current = head

    for i in range(1, len(values)):
        new_node = Node(int(values[i]))
        current.next = new_node  # Link current node to new node
        current = new_node       # Move to the new node
    return head  # Return the head of the list

# Main function equivalent
if __name__ == "__main__":
    my_string = input()  # Read the entire line of input
    values = my_string.split()  # Split the input into individual values
    head = create_linked_list(values)  # Create linked list from values

    # Solve and print the linked list to verify
    sol = Solution()
    output = sol.solve(head)

    # Convert to string manually
    result_string = " ".join(map(str, output))  # Join all elements with spaces
    print(result_string)
