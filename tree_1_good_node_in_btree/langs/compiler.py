class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def solve(self, root):
        # Example solution method (to be implemented)
        # Replace this with your actual logic
        return self.sum_tree(root)

    def sum_tree(self, node):
        if node is None:
            return 0
        return node.val + self.sum_tree(node.left) + self.sum_tree(node.right)


def build_tree_from_level_order(values):
    if not values or values[0] is None:
        return None
    
    root = TreeNode(values[0])
    queue = [root]
    i = 1
    
    while queue and i < len(values):
        current_node = queue.pop(0)
        
        # Process left child
        if i < len(values) and values[i] is not None:
            current_node.left = TreeNode(values[i])
            queue.append(current_node.left)
        i += 1
        
        # Process right child
        if i < len(values) and values[i] is not None:
            current_node.right = TreeNode(values[i])
            queue.append(current_node.right)
        i += 1
    
    return root


def main():
    my_string = input()  # Read the entire line of input
    values = my_string.split()
    
    # Convert string input to integer list with `None` for missing nodes
    values = [int(x) if x != "null" else None for x in values]
    
    root = build_tree_from_level_order(values)
    solution = Solution()
    output = solution.solve(root)
    print(output)


if __name__ == "__main__":
    main()
