from collections import defaultdict, deque

def solve():
    n, m = map(int, input().split())
    
    # Build adjacency list for the management tree
    # manager -> list of subordinates
    children = defaultdict(list)
    has_manager = set()
    
    for _ in range(m):
        u, v = map(int, input().split())
        children[u].append(v)
        has_manager.add(v)
    
    # Find all root nodes (directors - employees with no manager)
    roots = []
    for i in range(n):
        if i not in has_manager:
            roots.append(i)
    
    # Find maximum depth across all trees
    max_depth = 0
    
    def dfs(node):
        if not children[node]:
            return 1
        
        max_child_depth = 0
        for child in children[node]:
            max_child_depth = max(max_child_depth, dfs(child))
        
        return max_child_depth + 1
    
    # Calculate depth for each tree and take maximum
    for root in roots:
        depth = dfs(root)
        max_depth = max(max_depth, depth)
    
    return max_depth

print(solve())