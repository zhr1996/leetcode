class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        //check
        int sumCol = 0;
        for (int col : colsum){
            sumCol += col;
        }
        if (sumCol != (upper + lower)){
            return result;
        }
        for (int i = 0; i < colsum.length; ++i){
            if (upper < 0 || lower < 0){
                result = new ArrayList<>();
                return result;
            }
            if (colsum[i] == 0){
                up.add(0);
                down.add(0);
            }
            else if (colsum[i] == 2){
                up.add(1);
                down.add(1);
                upper--;
                lower--;
            }
            else{
                if (upper >= lower){
                    up.add(1);
                    upper--;
                    down.add(0);
                }
                else{
                    down.add(1);
                    lower--;
                    up.add(0);
                }
            }
        }
        result.add(up);
        result.add(down);
        return result;
    }
}