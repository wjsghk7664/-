class Solution {
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        
        val q = ArrayDeque<Node>()
        
        q.addLast(Node(arrayOf("ICN"),BooleanArray(tickets.size){false}))
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            
            if(cur.used.filter{!it}.isEmpty()) {
                answer = checkOrder(answer,cur.cur)
                continue
            }
            
            for((i,v) in tickets.withIndex()){
                if(v[0]==cur.cur.last()&&!cur.used[i]){
                    val new = Node(cur.cur.copyOf()+v[1],cur.used.copyOf().apply{this[i]=true})
                    q.addLast(new)
                }
            }
        }
        
        return answer
    }
    

    fun checkOrder(a:Array<String>, b:Array<String>):Array<String>{
        if(a.isEmpty()) return b
        for(i in a.indices){
            if(a[i]!=b[i]){
                if(a[i]==arrayOf(a[i],b[i]).sorted()[0]) return a else return b
            }
        }
        return a
    }
}

class Node(val cur:Array<String>, val used:BooleanArray)