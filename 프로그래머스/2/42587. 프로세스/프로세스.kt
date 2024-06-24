class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var queue=ArrayDeque<Pair<Int,Int>>()
        priorities.forEachIndexed{i,v -> queue.addLast(Pair(v,i))}
        var idx=1
        while(true){
           val cur=queue.removeFirst()
           var flag=false
           for(i in queue){
               if(i.first>cur.first){
                   queue.addLast(cur)
                   flag=true
                   break
               }
           }
           if(!flag){
               if(cur.second==location) break
               idx++
           }
           
        }
        return idx
    }
}