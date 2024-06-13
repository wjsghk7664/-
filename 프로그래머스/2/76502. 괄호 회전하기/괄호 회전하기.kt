class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val max=s.length
        var deque=ArrayDeque<Char>()
        for(i in s){
            deque.addLast(i)
        }
        
        repeat(max){
            deque.addLast(deque.removeFirst())
            if(check(deque)){
                answer++
            }
        }
        return answer
    }
    
    fun check(deque:ArrayDeque<Char>):Boolean{
        val stack=ArrayDeque<Char>()
        for(i in 0..deque.size-1){
            if(stack.isEmpty()){
                stack.addFirst(deque[i])
                continue
            } 
            val tmp=stack[0]
            if(tmp=='('&&deque[i]==')') stack.removeFirst()
            else if(tmp=='['&&deque[i]==']') stack.removeFirst()
            else if(tmp=='{'&&deque[i]=='}') stack.removeFirst()
            else stack.addFirst(deque[i])
        }
        if(stack.isEmpty()) return true
        else return false
    }
}