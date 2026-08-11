class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> data; 

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        data.putIfAbsent(key, new ArrayList<>());
        data.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> arr = data.get(key);

        int l = 0, r = arr.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m).getKey() <= timestamp) {
                res = arr.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;

    }
}
