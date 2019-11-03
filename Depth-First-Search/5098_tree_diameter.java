class Solution {
    public int treeDiameter(int[][] edges) {
        if(edges.length < 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if(!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int[] far = dfs(map, edges[0][0], visited);
        int[] result = dfs(map, far[0], visited);
        return result[1];
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int st, Set<Integer> visited){
        visited.add(st);
        int dist = 0;
        int node = st;
        for(int adj : map.get(st)){
            if(!visited.contains(adj)){
                int[] returnedValues = dfs(map, adj, visited);
                if(dist < returnedValues[1]+1){
                    dist = returnedValues[1]+1;
                    node = returnedValues[0];
                }
            }
        }
        visited.remove(st);
        return new int[]{node, dist};
    }
}