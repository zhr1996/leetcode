class Solution {
    //Swap tail
    //Use hashmap, whenever we choose a number, we map it to the tail
    //Then choose a random number from in range of total -  1 
    Map<Integer, Integer> map;
    int m, n, total;
    Random rand;

    public Solution(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        m = n_rows;
        n = n_cols;
        reset();
    }

    public int[] flip() {
        int i = rand.nextInt(total--);
        int x = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(total, total));
        return new int[]{x / n, x % n};
    }

    public void reset() {
        map.clear();
        total = m * n;
    }
}