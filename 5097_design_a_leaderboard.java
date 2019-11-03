class Leaderboard {
    
    Map<Integer, Integer> board;
    
    public Leaderboard() {
        this.board = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(board.containsKey(playerId)){
            board.put(playerId, board.get(playerId) + score);
        }
        else{
            board.put(playerId, score);
        }
    }
    
    public int top(int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : board.entrySet()) {
            queue.offer(entry.getValue());

        }
        int sum = 0;
        while(K > 0 && queue.size()>0){
            sum += queue.poll();
            K--;
        }
        return sum;
        
    }
    
    public void reset(int playerId) {
        board.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */