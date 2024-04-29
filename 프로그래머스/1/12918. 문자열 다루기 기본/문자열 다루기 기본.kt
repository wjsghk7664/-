class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        if(s.length!=4&&s.length!=6){
            answer=false
        }
        for(i:Int in 0..s.length-1){
            if(s[i] !in '0'..'9'){
                answer=false
            }
        }
        return answer
    }
}