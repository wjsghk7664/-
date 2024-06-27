class Solution {
    fun solution(n: Int, count: Int): Int {
        var answer: Int = 0
        
        val dp=Array(n+1){LongArray(n+1){0}}
        
        val mod=1000000007L
        
        //dp[i][j]: i쌍의 빌딩을 가지고 j개의 빌딩이 보이게 하는 경우의수. i가 커질때 더 작은 빌딩을 넣는 연산
        //dp[1][1]=1
        //dp[i][j]가지고 dp[i+1][j],dp[i+1][j+1]만들기
        //dp[i+1][j]: 맨 앞을 제외하고 아무곳이나 집어넣으면 됨(단 쌍을 붙인 상태로):dp[i][j]*2i
        //dp[i+1][j+1]: 맨 앞에 두면 됨:dp[i][j]
        dp[1][1]=1L
        for(i in 1..n-1){
            for(j in 1..i){
                dp[i+1][j]+=dp[i][j]*2*i
                dp[i+1][j+1]+=dp[i][j]
                dp[i+1][j]%=mod
                dp[i+1][j+1]%=mod
            }
        }
        
        return (dp[n][count]%mod).toInt()
    }
}