class Solution { 
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        HashMap<Integer, Node> pointers = new HashMap<Integer, Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Node> nodesToVisit = new LinkedList<Node>();
        
        Node head = new Node(node.val);
        pointers.put(head.val, head);
        nodesToVisit.add(node);
        
        while (!nodesToVisit.isEmpty()) {
            Node originalNode = nodesToVisit.poll();
            if (visited.contains(originalNode.val)) continue;
            
            Node currNode;
            if (pointers.containsKey(originalNode.val)) {
                currNode = pointers.get(originalNode.val);
            } else {
                pointers.put(originalNode.val, new Node(originalNode.val));
                currNode = pointers.get(originalNode.val);
            }
            
            for (int i = 0; i < originalNode.neighbors.size(); i++) {
                Node originalNeighbor = originalNode.neighbors.get(i);
                if (!visited.contains(originalNeighbor.val)) {
                    nodesToVisit.add(originalNeighbor);
                }
                
                Node currNeighbor;
                if (pointers.containsKey(originalNeighbor.val)) {
                    currNeighbor = pointers.get(originalNeighbor.val);
                } else {
                    pointers.put(originalNeighbor.val, new Node(originalNeighbor.val));
                    currNeighbor = pointers.get(originalNeighbor.val);
                }
                
                currNode.neighbors.add(currNeighbor);
            }
            
            visited.add(originalNode.val);
        }
        
        return head;
    }
}
