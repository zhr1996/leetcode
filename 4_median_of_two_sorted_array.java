class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0){
            if(n%2==1){
                return nums2[n/2];
            }
            else{
                return (nums2[n/2-1]+nums2[n/2])/2.0;
            }
        }
        int imin = 0;
        int imax = m;
        int i = 0;
        int j =0;
        int max_left = 0;
        int min_right = 0;
        while(imin <= imax){
            i = (imin+imax)/2;
            j = (m+n+1)/2 - i;        //This is important odd and even
            if( i<m && nums1[i]<nums2[j-1]){
                imin = i + 1;
            }
            else if(i>0 && nums1[i-1]>nums2[j]){
                imax = i - 1;         //问题就在于i=0的时候， j是什么情况
            }
            else{                    //perfect
                break;
            }
        }
        if(i==0){
            max_left = nums2[j-1];
        }
        else if(j==0){
            max_left = nums1[i-1];
        }
        else{
            max_left = Math.max(nums1[i-1],nums2[j-1]);
        }
        if(i==m){
            min_right = nums2[j];
        }
        else if(j==n){
            min_right = nums1[i];
        }
        else{
            min_right = Math.min(nums1[i],nums2[j]);
        }
        if( (m+n)%2 != 0){
            return max_left;
        }
        else{
           
            return (max_left + min_right)/2.0;
        }
        
    }
}