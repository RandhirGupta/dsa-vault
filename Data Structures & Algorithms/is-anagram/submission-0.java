class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            if (count - 1 < 0) {
                return false;
            }

            map.put(t.charAt(i), count - 1);
        }

        return true;
    }
}
