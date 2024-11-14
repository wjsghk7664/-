class Solution {
    fun solution(n: Int, count: Int): Int {
        var answer: Int = 0
        
        val dp = Array(n+1){LongArray(n+1)}
        
        val MOD =1000000007L
        
        dp[1][1]=1
        
        //dp[i][j]로 만들기: 큰것부터 작아지는 순으로. 
        //dp[i+1][j]: 가장 작은 건물 추가 이므로 맨 앞만 아니면 됨. 단, 두 건물 사이에 어떤 건물도 못 들어오므로 쌍을 붙여서 다님 
        //->들어갈 수 있는 자리는 2i개 
        //dp[i+1][j+1]: 가장 작은 건물 추가이므로 맨 앞이면 됨. 
        
        for(i in 1..n-1){
            for(j in 1..i){
                dp[i+1][j]+=dp[i][j]*2*i
                dp[i+1][j]%=MOD
                dp[i+1][j+1]+=dp[i][j]
                dp[i+1][j+1]%=MOD
            }
        }
        return dp[n][count].toInt()
    }
}