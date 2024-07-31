import java.util.*
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        
        val pq=PriorityQueue<IntArray>(compareBy{it[1]})
        
        jobs.sortWith(compareBy<IntArray>{it[0]}.thenBy{it[1]})
        
        pq.offer(jobs[0])
        
        var idx=1
        var time=jobs[0][0]
        
        var total=0
        
        while(pq.isNotEmpty()){
            val cur = pq.poll()
            if(cur[0]<=time) time+=cur[1]
            else time=cur[0]+cur[1]
            total+=time-cur[0]
            if(idx<jobs.size){
                while(idx<jobs.size){
                    if(jobs[idx][0]<time) pq.offer(jobs[idx++])
                    else break
                }
                if(idx<jobs.size&&pq.isEmpty()) pq.offer(jobs[idx++])    
            }
            
        }
        
        answer=total/jobs.size
        
        return answer
    }
}