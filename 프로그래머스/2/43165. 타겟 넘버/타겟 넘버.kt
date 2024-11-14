class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        val q = ArrayDeque<Pair<Int,Int>>() //인덱스 총합
        
        q.addLast(Pair(0,numbers[0]))
        q.addLast(Pair(0,-numbers[0]))
        
        while(q.isNotEmpty()){
            val (curi,curt) = q.removeFirst()
            
            
            if(curi==numbers.size-1){
                if(curt==target) answer++
                continue
            }
            
            q.addLast(Pair(curi+1,curt+numbers[curi+1]))
            q.addLast(Pair(curi+1,curt-numbers[curi+1]))
        }
        return answer
    }
}

