class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        
        val q=ArrayDeque<Int>(bridge_length)
        repeat(bridge_length){
            q.addLast(0)
        }
        var total=0
        var idx=0
        
        while(true){
            total-=q.removeFirst()
            answer++
            if(total==0&&idx==truck_weights.size) break
            
            if(idx<truck_weights.size&&weight-total>=truck_weights[idx]){
                val tmp=truck_weights[idx++]
                total+=tmp
                q.addLast(tmp)
            }else{
                q.addLast(0)
            }
        }
        
        
        return answer
    }
}