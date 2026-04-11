class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();

        Map<String, List<String>> g = new HashMap<>();

        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        for (int i = 0; i < tickets.size(); i++) {
            g.putIfAbsent(tickets.get(i).get(0), new ArrayList<>());
        }

        for (List<String> ticket : tickets) {
            g.get(ticket.get(0)).add(ticket.get(1));
        }

        res.add("JFK");

        if (dfs("JFK", res, g, tickets.size() + 1)) {
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs(String src, List<String> res, Map<String, List<String>> g, int ticketLength) {
        if (res.size() == ticketLength){
            return true;
        }

        if (!g.containsKey(src)) {
            return false;
        }

        ArrayList<String> temp = new ArrayList<>(g.get(src));

        for (int i = 0; i < temp.size(); i++) {
            String dest = temp.get(i);
            g.get(src).remove(i);
            res.add(dest);
            if (dfs(dest, res, g, ticketLength)) {
                return true;
            }
            res.remove(res.size() - 1);
            g.get(src).add(i, dest);
        }
        return false;
    }


}
