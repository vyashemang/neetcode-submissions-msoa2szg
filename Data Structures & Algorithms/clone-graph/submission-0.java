/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> g = new HashMap<>();

        helper(node, g);

        for (Map.Entry<Node, Node> entry : g.entrySet()) {
            Node original = entry.getKey();
            Node cloned = entry.getValue();

            for (Node n : original.neighbors) { 
                cloned.neighbors.add(g.get(n));
            }
        }

        return g.get(node);
    }

    private void helper(Node node, Map<Node, Node> g) {

        if (node == null || g.containsKey(node)) {
            return;
        }

        g.putIfAbsent(node, new Node(node.val));
        for (Node n : node.neighbors) {
            helper(n, g);
        }
    }
}