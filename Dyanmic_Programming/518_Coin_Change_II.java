class Solution {
  //
    public int helper(int amount,int[] coins,int index,int[][] dp){
        if(index==coins.length || amount<0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int take=helper(amount - coins[index],coins,index,dp);
        int nottake=helper(amount,coins,index+1,dp);

        return dp[index][amount]=take+nottake;
    }
    public int change(int amount, int[] coins) {
      //Top Down Approach
       /* int[][] dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(amount,coins,0,dp);*/
      // Bottom up approach

      /*  int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int amt=0;amt<=amount;amt++){
                if(amt<coins[i-1]){
                    dp[i][amt]=dp[i-1][amt];
                }
                else{
                    dp[i][amt]=dp[i-1][amt]+dp[i][amt-coins[i-1]];                }
            }
        }
        return dp[coins.length][amount];
        */
      //1 D approach
        int[] dp=new int[amount+1];

        dp[0]=1;

        for(int coin:coins){
            for(int amt=coin;amt<=amount;amt++){
                dp[amt]=dp[amt]+dp[amt-coin];
            }
        }
        return dp[amount];
    }
}
Recursion
Time complexity=O(2amount*coins)
  space complexity=O(1)
Top Down Approach 2d dp
  Time complexity=O(amount*coins)
  space complexity=O(amount * coins)
Bottom Up Approach 2d dp
  Time complexity=O(amount*coins)
  space complexity=O(amount*coins)

  1d Dp
  Time complexity=O(amount*coins)
  space complexity=O(amount)  
  
  
  
  c
  



