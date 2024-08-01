import java.util.*
class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        var size=0
        
        val upq=PriorityQueue<Node>(compareBy{-it.n})
        val dpq=PriorityQueue<Node>(compareBy{it.n})
        
        for(i in operations){
            if(i == "D 1"){
                if(size>0){
                    getNonNull(upq)
                    size--
                }
            }else if(i =="D -1"){
                if(size>0){
                    getNonNull(dpq)
                    size--
                }
            }else{
                i.split(" ")[1].toInt().let{
                    val node=Node(it)
                    upq.offer(node)
                    dpq.offer(node)
                    size++
                }
                
            }
        }
        
        if(size==1){
            val tmp = getNonNull(upq)!!.n
            return intArrayOf(tmp,tmp)
        }else if(size>1){
            answer+=getNonNull(upq)!!.n
            answer+=getNonNull(dpq)!!.n 
        }
        else{
            return intArrayOf(0,0)
        }
        
        
        return answer
    }
    
    fun getNonNull(pq:PriorityQueue<Node>):Node?{
        var tmp:Node? =null
        while(true){
            tmp = pq.poll()
            if(tmp.check){
                tmp.check=false
                break
            }
        }
        return tmp
    }
}

data class Node(val n:Int, var check:Boolean=true)