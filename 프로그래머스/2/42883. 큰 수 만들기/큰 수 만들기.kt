import java.util.*
class Solution {
    fun solution(number: String, k: Int): String {
        val tmp=StringBuilder()
        var del=k
        var idx=0
        val deq=ArrayDeque<Int>()
        
        while(idx!=number.length){
            val num=minOf(del-deq.size+idx,number.length-1)
            while(idx<=num){
                val cur=number[idx++].toString().toInt()
                while(deq.isNotEmpty()&&del!=0&&cur>deq.peekFirst()){
                    deq.removeFirst()
                    del--
                }
                deq.addFirst(cur)

            } 
            tmp.append(deq.removeLast())
        }
        
        repeat(deq.size-del){
            tmp.append(deq.removeLast())
        }
        
        //del남으면 deque의 앞부분을 del만큼 제거=>즉 del만큼 남게 deque에서 뒤로 빼주고 남은건 버림
        return tmp.toString()
    }
}