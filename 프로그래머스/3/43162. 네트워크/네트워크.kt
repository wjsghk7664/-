class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val q=ArrayDeque<Int>()
        val visited=BooleanArray(n){false}
        
        q.addLast(0)
        visited[0]=true
        answer++
        
        while(q.isNotEmpty()){
            val cur=q.removeFirst()
            
            for(i in 0..n-1){
                if(!visited[i]&&computers[cur][i]==1){
                    q.addLast(i)
                    visited[i]=true
                }
            }
            if(q.isEmpty()){
                for(i in 0..n-1){
                    if(!visited[i]){
                        q.addLast(i)
                        visited[i]=true
                        println(i)
                        answer++
                        break
                    }
                }
            }
        }
        
        
        return answer
    }
}