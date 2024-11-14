class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        
        val dp = Array(9){HashSet<Int>()}
        
        //초기값으로 N,NN,NNN...추가
        var tmpN=N
        for(i in 1..8){
            dp[i]+=tmpN
            tmpN=tmpN*10+N
        }
        
        for(i in 1..8){
            for(j in 1..i){
                if(i+j>8) break
                for(v1 in dp[i]){
                    for(v2 in dp[j]){
                        dp[i+j]+=hashSetOf(v1+v2, v1-v2, v2-v1,v1*v2)
                        if(v1!=0) dp[i+j]+=v2/v1
                        if(v2!=0) dp[i+j]+=v1/v2
                    }
                }
            }
        }
        for(i in 1..8){
            if(dp[i].contains(number)) return i
        }
        return -1
    }
}