class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q = ArrayDeque<Pair<Int,Int>>() // 인덱스, 중요도
        var answer = 0
        
        for((i,v) in priorities.withIndex()){
            q.addLast(Pair(i,v))
        }
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            var isExe = true
            for(i in q){
                if(i.second>cur.second){
                    isExe = false
                    break
                }
            }
            if(!isExe){
                q.addLast(cur)
            }else{
                answer++
                if(cur.first == location){
                    break
                }
            }
        }
        return answer
    }
}