class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        answer=nextPaint(n,m,section[0],section)
        return answer
    }
    
    fun nextPaint(n:Int, m:Int, next:Int, section:IntArray):Int{
        var answer=0
        if(next>n){
            return 0
        }
        if(section.contains(next)){
            answer+=1
            answer+=nextPaint(n,m,next+m,section)
        }
        else{
            answer+=nextPaint(n,m,next+1,section)
        }
        return answer
        
    }
}