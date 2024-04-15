class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var sum =0
        var tmp = x
        while(tmp>0){
            sum+=tmp%10
            tmp/=10
        }
        if(x%sum==0){
            answer=true
        }
        else{
            answer=false
        }
        return answer
    }
}