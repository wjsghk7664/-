class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        
        val q = ArrayDeque<Int>()
        
        var idx = 0
        
        repeat(bridge_length){
            q.addLast(0)
        }
        
        var time = 0
        var sum = 0
        
        while(true){
            time++
            sum-=q.removeFirst()
            if(idx<truck_weights.size&&sum + truck_weights[idx] <= weight){
                val adder = truck_weights[idx++]
                q.addLast(adder)
                sum+=adder
            }else{
                q.addLast(0)
            }
            
            if(sum==0){
                break
            }
        }
        
        
        return time
    }
}