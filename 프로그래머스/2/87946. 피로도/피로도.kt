class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = 0
        
        var maxvisit= 0
        
        val q = ArrayDeque<Node>()
        
        q.addLast(Node(k,BooleanArray(dungeons.size){false}))
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            maxvisit = maxOf(maxvisit,cur.visited.filter{it}.size)
            for((i,v) in dungeons.withIndex()){
                if(v[0]<=cur.k&&!cur.visited[i]){
                    val new = Node(cur.k - v[1],cur.visited.copyOf().apply{this[i]=true})
                    if(new.k>=0) q.addLast(new)
                }
                
            }
        }
        return maxvisit
    }
    
}

data class Node(val k:Int, val visited:BooleanArray)