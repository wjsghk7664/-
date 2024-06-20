class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        val road=Array<HashSet<Int>>(n+1){hashSetOf<Int>()}
        
        for(i in roads){
            road[i[0]].add(i[1])
            road[i[1]].add(i[0])
        }
    
        
        val queue=ArrayDeque<Int>()
        val costs=IntArray(n+1){500000}
        
        val ends=hashSetOf<Int>()
        for(i in sources){
            ends.add(i)
        }
        
        costs[destination]=0
        queue.addLast(destination)

        while(queue.isNotEmpty()){
            val cur=queue.removeFirst()
            
            val tmp=1+costs[cur]
            for(i in road[cur]){
                if(tmp<costs[i]){
                    costs[i]=tmp
                    queue.addLast(i)
                }
            }
        }
        
         
         for(i in sources){
             val tmp=costs[i]
             answer+=if(tmp==500000) -1 else tmp 
         }
        
        
        return answer
    }
    
}