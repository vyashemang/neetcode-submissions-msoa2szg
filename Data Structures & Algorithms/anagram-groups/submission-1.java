class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
    for(String str:strs)
    {
        char alphabets[] = new char[26]; //frequency
        for(char ch:str.toCharArray())
        {
            alphabets[ch-'a']++;
        }
        String key = String.valueOf(alphabets);
        if(!map.containsKey(key))
            map.put(key,new ArrayList<>()); //Step-1
        map.get(key).add(str); //Step-2
    }
    return new ArrayList<>(map.values());
    }


}
