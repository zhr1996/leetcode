class Solution {
    //Solution based on TreeMap
    //A kind of map whose key is sorted according to natural sequence
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        //put (intervals[i][0], i) into the map, so later can retrieve its index
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i][0], i);    
        }
        
        //check ceiling entry for every interval[i][1], then get the entry's value store it in result
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
}