class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        var tmp:Long = x.toLong()
        for(i:Int in 1..n){
            answer.set(i-1,tmp)
            tmp+=x.toLong()
        }
        return answer
    }
}