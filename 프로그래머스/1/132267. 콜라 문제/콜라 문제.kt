class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var left=n
        var total=0
        while(left>=a){
            total+=(left/a)*b
            left=(left/a)*b+left%a
        }
        answer=total
        return answer
    }
}