class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val q = ArrayDeque<Int>()
        val visited = BooleanArray(n){false}
        
        q.addLast(0)
        visited[0]=true
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            for((i,v) in computers[cur].withIndex()){
                if(!visited[i]&&v==1){
                    visited[i]=true
                    q.addLast(i)
                }
            }
            if(q.isEmpty()){
                answer++
                for((i,v) in visited.withIndex()){
                    if(!v){
                        q.addLast(i)
                        visited[i]=true
                        break
                    }
                }
            }
        }
        
        return answer
    }
}