class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var tmp=n
        var three=arrayOf<Int>()
        while(tmp>0){
            three+=tmp%3
            tmp/=3
        }
        var pow=1
        for(i:Int in three.size-1 downTo 0){
            answer+=three[i]*pow
            pow*=3
        }
        return answer
    }
}