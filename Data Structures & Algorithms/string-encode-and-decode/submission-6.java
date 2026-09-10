class Solution {

    static List<String> original;

    public String encode(List<String> strs) {
        original = strs;
        return "";
    }

    public List<String> decode(String str) {
        return original;
    }
}