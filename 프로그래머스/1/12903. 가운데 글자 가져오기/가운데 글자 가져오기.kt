class Solution {
    fun solution(s: String): String {
        var answer = ""
        var len=s.length
        answer=if(len%2==0){
            s.substring(len/2-1,len/2+1)
        }
        else{
            s.substring(len/2,len/2+1)
        }
        return answer
    }
}