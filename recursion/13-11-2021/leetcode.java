//191
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        
        return count;
    }
}

//231
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}

//342
class Solution {
    public boolean isPowerOfFour(int n) {
        if ((n<=0) || (n&(n-1))!=0){
            return false;
        }
        
        int count=0;
        while(n!=1){
            n>>>=1;
            count++;
        }
        
        return ((count&1)==0);
    }
    
//     public boolean isPowerOfFour(int n){
//         if(n==0)    return false;
//         if(n==1)    return true;
//         boolean ans=false;
//         if(n%4==0){
//             ans=ans || isPowerOfFour(n/4);
//         }
//         return ans;
//     }
}

//338 
class Solution {
    
    public int[] countBits(int n){
        int[] ans=new int[n+1];
        
        for(int i=1; i<=n; ++i){
            ans[i]=ans[(i&(i-1))]+1;
        }
        
        return ans;
    }
    
//     public int[] countBits(int n) {
//         int[] arr=new int[n+1];
//         for(int i=0; i<=n; ++i){
//             arr[i]=hammingWeight(i);
//         }
//         return arr;
//     }
//     public int hammingWeight(int n) {
//         int count=0;
//         while(n!=0){
//             n&=(n-1);
//             count++;
//         }       
//         return count;
//     }
}

//260
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int ele: nums)  xor^=ele;
        
        int mask=xor&(-xor);
        
        int a=0, b=0;
        for(int ele: nums){
            if((ele&mask)==0)
                a^=ele;
            else
                b^=ele;
        }
        
        return new int[]{a, b};
    }
}
