class Solution {
    fun solution(s: String): String {
        var answer = ""
        var len=s.length
        if(len%2==0){
            answer=s.substring(len/2-1,len/2+1)
        }
        else{
            answer=s.substring(len/2,len/2+1)
        }
        return answer
    }
}