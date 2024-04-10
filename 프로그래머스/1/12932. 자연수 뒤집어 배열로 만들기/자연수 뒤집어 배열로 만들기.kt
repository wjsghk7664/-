class Solution {
    fun solution(n: Long): LongArray {
        var answer = longArrayOf()
        var tmp=n
        while(tmp>0){
            answer+=(tmp%10)
            tmp/=10
        }
        return answer
    }
}