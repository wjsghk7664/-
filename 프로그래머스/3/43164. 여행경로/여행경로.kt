class Solution {
    
    data class Node(val route:Array<String>, val used:BooleanArray)
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        
        val q=ArrayDeque<Node>()
        
        q.addLast(Node(arrayOf("ICN"),BooleanArray(tickets.size){false}))
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            
            if(!cur.used.contains(false)){
                answer = if(answer.isEmpty()) cur.route else compares(answer,cur.route)
                continue
            }
            
            for(i in tickets.indices){
                if(!cur.used[i]&&tickets[i][0]==cur.route.last()){
                    val new=Node(cur.route+tickets[i][1],cur.used.copyOf().also{it[i]=true})
                    q.addLast(new)
                }
            }
        }
        
        
        
        return answer
    }
    
    fun compares(str1:Array<String>,str2:Array<String>):Array<String>{
        for(i in str1.indices){
            val tmp = str1[i].compareTo(str2[i])
            if(tmp!=0){
                return if(tmp<0) str1 else str2
            }
        }
        return str1
    }
}