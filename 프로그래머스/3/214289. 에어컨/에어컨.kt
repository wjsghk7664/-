class Solution {
    fun solution(temperature: Int, t1: Int, t2: Int, a: Int, b: Int, onboard: IntArray): Int {
        var answer: Int = 0
        val max=maxOf(t2,temperature)+10
        val min=minOf(t1,temperature)+10
        val maxcost=maxOf(a,b)*onboard.size
        
        val dp=Array<IntArray>(onboard.size+1){IntArray(51){maxcost}} //[시간][온도]
        
        dp[0][temperature+10]=0
        
        for(i in 1..dp.size-1){
            for(j in min..max){
                if(onboard[i-1]==1&&(j<t1+10||j>t2+10)){
                    dp[i][j]=maxcost
                    continue
                }
                
                val offcosts=ArrayList<Int>()
                if(j-1<temperature+10&&j-1>=0) offcosts+=dp[i-1][j-1]
                if(j+1>temperature+10&&j+1<=50) offcosts+=dp[i-1][j+1]
                if(j==temperature+10) offcosts+=dp[i-1][j]
                
                val offcost=offcosts?.minOrNull() ?:maxcost
                val onUp=if(j+1<=50) dp[i-1][j+1]+a else maxcost
                val onDown=if(j-1>=0) dp[i-1][j-1]+a else maxcost
                val onEqual=dp[i-1][j]+b
                
                dp[i][j]=minOf(offcost,onUp,onDown,onEqual)
            }
        }
        
        answer=dp[dp.size-1].minOrNull() as Int
        println(dp[dp.size-1].contentToString())
        return answer
    }
    
}