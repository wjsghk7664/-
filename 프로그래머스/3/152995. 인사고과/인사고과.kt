class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 0
        var hset=ArrayList<Int>()
        var mysum=scores[0][0]+scores[0][1]
        
        
        
        
        for(i in scores.indices){
            if(scores[i][0]+scores[i][1]>mysum){
                hset+=i
            }
        }
        
        val tset=HashSet(hset)
        tset+=0
        
        for(i in tset){
            var flag=true
            for(j in hset){
                if(scores[i][0]<scores[j][0]&&scores[i][1]<scores[j][1]) {
                    if(i==0) return -1
                    flag=false
                    break
                }
            }
            if(flag&&i!=0) answer++
        }
        
        return answer+1
    }
}