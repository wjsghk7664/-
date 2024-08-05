class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        
        val dp = Array(9){HashSet<Int>()}
        
        //초기화
        var tmp = N
        for(i in 1..8){
            dp[i]+=tmp
            tmp=10*tmp+N
        }
        
        if(number==N) return 1
        
        for(i in 2..8){
            var prev=1
            while(prev<i){
                for(j in dp[prev]){
                    for(k in dp[i-prev]){
                        dp[i]+=j+k
                        dp[i]+=j-k
                        dp[i]+=j*k
                        if(k!=0) dp[i]+=j/k
                    }
                }
                prev++
            }
            if(dp[i].contains(number)) return i
        }
        
        return -1
    }
}