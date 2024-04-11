class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var front = s.substring(0,1)
        answer=s.substring(1).toInt()
        if(front=="-"){
            answer=s.substring(1).toInt()
            answer*=-1
        }
        else if(front=="+"){
            answer=s.substring(1).toInt()
        }
        else{
            answer=s.toInt()
        }
        return answer
    }
}