class Solution {
    fun solution(angle: Int): Int {
        var answer= when(angle){
            in 0..89 ->1
            90 ->2
            in 91..179 ->3
            else ->4
        }
        return answer
    }
}