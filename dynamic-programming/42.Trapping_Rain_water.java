class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        rightHighest[height.length-1] = 0;
        int max = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            if(height[i+1]>max){
                max = height[i+1];
                rightHighest[i] = max;
            }
            rightHighest[i] = max; 
        }
        max = 0;
        leftHighest[0] = 0;
        for(int i=1;i<=height.length-1;i++){
            if(height[i-1]>max){
                max = height[i-1];
                leftHighest[i] = max;
            }
            leftHighest[i] = max;
        }
        int result = 0;
        for(int i=1;i<=height.length-2;i++){
            if(leftHighest[i]<=height[i]||rightHighest[i]<=height[i]){
            }
            else{
                result = result + Math.min(leftHighest[i],rightHighest[i])-height[i];   
            }
        }
        return result;
    }
}