class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var answer: Int = 0
        
        val maxAlp=problems.map{it[0]}.maxOrNull() as Int
        val maxCop=problems.map{it[1]}.maxOrNull() as Int
        
        //초기 150, 0 에 req 150,150, 문제풀이시 30,2 씩 준다고 가정
        //그러면 최대 150+2250 = 2400
        val dp = Array(2401){IntArray(2401){Int.MAX_VALUE}}
        
        for(i in alp..maxOf(maxAlp,alp)){
            for(j in cop..maxOf(maxCop,cop)){
                dp[i][j]=i+j-alp-cop
            }
        }
        

        var min=Int.MAX_VALUE
        
        for(i in alp..2400){
            for(j in cop..2400){
                if(i>=maxAlp&&j>=maxCop){
                   min=minOf(min,dp[i][j])
                   continue
                } 
                if(dp[i][j]>=min) continue
                for(k in problems){
                    if(k[0]>i||k[1]>j) continue
                    val ni=i+k[2]
                    val nj=j+k[3]
                    if(ni>2400||nj>2400) continue
                    dp[ni][nj]=minOf(dp[ni][nj],dp[i][j]+k[4])
                }
            }
        }
        
        return min
    }
}