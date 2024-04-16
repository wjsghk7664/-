class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var count=0
        var tmp=num.toLong()
        while(tmp>1L){
            if(tmp%2L==0L){
                tmp/=2L
            }
            else{
                tmp=(tmp*3L) + 1L
            }
            count++
            if(count==500){
                break
            }
        }
        answer = when(count){
            0 -> 0
            in 1..499 -> count
            else -> -1
        }
        return answer
    }
}