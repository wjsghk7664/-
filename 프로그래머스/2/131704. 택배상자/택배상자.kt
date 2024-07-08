import java.util.*
class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = ArrayDeque<Int>()
        var max=0
        var idx=1
        for(i in order){
            if(idx<i){
                while(idx<i){
                    max=idx
                    stack.push(idx++)
                }
                answer++
                idx++
            }else if(idx>i){
                if(max==i){
                    stack.pop()
                    max=stack.peek()?:0
                    answer++
                }else{
                    break
                }
            }else{
                answer++
                idx++
            }
        }
        return answer
    }
}