class MajorityChecker {

    int[] array;
    HashMap<String, ValueToCount> memo;
    public MajorityChecker(int[] arr) {
        this.array = arr;
        this.memo = new HashMap<String, ValueToCount>();
    }
    
    public int query(int left, int right, int threshold) {
        int majority = array[left], count = 0;
        String key = left +"#" + right;
        if(this.memo.containsKey(key)) {
            ValueToCount valToCount = this.memo.get(key);
            majority = valToCount.val;
            count = valToCount.count;
        } else {
            for(int i = left; i <= right; ++i) {
                if(majority == array[i]){
                    ++count;
                } else {
                    --count;
                    if(count < 0) {
                        count = 1;
                        majority = array[i];
                    }
                }
            }
            
            count = 0;
            for(int i = left; i <= right; ++i) {
                if(array[i] == majority) {
                    ++count;
                }
            }
            
            this.memo.put(key, new ValueToCount(majority, count));
        }
        
        if(count >= threshold) {
            return majority;
        }
               
        
        return -1;
    }
    
    public class ValueToCount {
        public int val;
        public int count;
        
        public ValueToCount(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
