class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {

        
        val dp=IntArray(y+1){Int.MAX_VALUE} //dp[현재값]=최소 연산 횟수
        dp[x]=0
        //-1은 존재하지 않는 수이므로 스킵
        for(i in 0..y-1){
            if(dp[i]==Int.MAX_VALUE) continue
            if(i+n<=y) dp[i+n]=minOf(dp[i+n],dp[i]+1)
            if(i*2<=y) dp[i*2]=minOf(dp[i*2],dp[i]+1)
            if(i*3<=y) dp[i*3]=minOf(dp[i*3],dp[i]+1)
        }
        
        if(dp[y]==Int.MAX_VALUE) return -1
        else return dp[y]

    }
}