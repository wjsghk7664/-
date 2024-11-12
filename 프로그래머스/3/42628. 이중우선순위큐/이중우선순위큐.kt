import java.util.*
class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        
        val q = PriorityQueue<Node>({a,b -> a.n - b.n})
        val rq = PriorityQueue<Node>({a,b -> b.n - a.n})
        
        for(i in operations){
            val order = i.split(" ")
            if(order[0]=="I"){
                val node = Node(n = order[1].toInt())
                q.add(node)
                rq.add(node)
            }else{
                if(order[1]=="-1"){
                    while(q.isNotEmpty()){
                        val poll = q.poll()
                        if(!poll.isErased){
                            poll.isErased = true
                            break
                        }
                    }
                }else{
                    while(rq.isNotEmpty()){
                        val poll = rq.poll()
                        if(!poll.isErased){
                            poll.isErased = true
                            break
                        }
                    }
                }
            }
        }
        
        while(rq.isNotEmpty()){
            val poll = rq.poll()
            if(!poll.isErased) {
                answer+=poll.n
                break
            }
        }
        while(q.isNotEmpty()){
            val poll = q.poll()
            if(!poll.isErased) {
                answer+=poll.n
                break
            }
        }
        if(answer.isEmpty()){
            answer+=0
            answer+=0
        }
        
        return answer
    }
    
    
}

data class Node(var isErased:Boolean = false, val n:Int)