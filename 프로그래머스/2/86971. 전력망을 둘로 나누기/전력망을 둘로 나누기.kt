class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        val link = Array(n+1){BooleanArray(n+1){false}}
        
        for(i in wires){
            val a = i[0]
            val b = i[1]
            
            link[a][b]=true
            link[b][a]=true
        }
        
        var min = Int.MAX_VALUE
        
        for(i in wires){
            val q = ArrayDeque<Int>()
            val visited = BooleanArray(n+1){false}
            q.addLast(i[0])
            visited[i[0]]=true
            
            link[i[0]][i[1]]=false
            link[i[1]][i[0]]=false
            
            while(q.isNotEmpty()){
                val cur = q.removeFirst()
                
                for((j,v) in link[cur].withIndex()){
                    if(v&&!visited[j]){
                        q.addLast(j)
                        visited[j]=true
                    }
                }
            }
            
            min=minOf(min, Math.abs(n-2*visited.filter{it}.size))
            
            link[i[0]][i[1]]=true
            link[i[1]][i[0]]=true
            
        }
        
        return min
    }
    
    
}