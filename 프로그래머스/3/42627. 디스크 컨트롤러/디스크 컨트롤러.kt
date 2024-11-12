import java.util.*
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        
        val pq = PriorityQueue<IntArray>(compareBy<IntArray>{it[1]}.thenBy{it[0]})
        
        var time = 0
        
        jobs.sortBy{it[0]}
        
        var idx = 0
        
        while(true){
            if(pq.isEmpty()&&idx<jobs.size){
                pq.add(jobs[idx])
                time = maxOf(time,jobs[idx][0])
                idx++
            }
            while(idx<jobs.size){
                val cur = jobs[idx]
                if(cur[0]<=time){
                    pq.add(cur)
                    idx++
                }else{
                    break
                }
            }
            
            if(pq.isEmpty()) break
            
            val poll = pq.poll()
            
            time +=poll[1]
            answer+=time-poll[0]
            

            
        }
        
        return answer/jobs.size
    }
}