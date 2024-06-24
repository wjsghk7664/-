import java.util.*

class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        val path=Array(n+1){ArrayList<Pair<Int,Int>>()}//인덱스는 출발지, Pair(도착지, weight)
        
        val summit=hashSetOf<Int>()
        for(i in summits) summit.add(i)
        

        
        //패스 구성
        for(i in paths){
            path[i[0]]+=Pair(i[1],i[2])
            path[i[1]]+=Pair(i[0],i[2])
        }
        
        
        val costs=IntArray(n+1){Int.MAX_VALUE} //각 지점까지의 최소 intensity
        
        val q:Queue<Pair<Int,Int>> =ArrayDeque<Pair<Int,Int>>() //현 위치, 현 위치까지 최대 edge
        
        for(i in gates){
            q.offer(Pair(i,0))
            costs[i]=0
        }
        
        while(q.isNotEmpty()){
            val (cur,cost)=q.poll()
            
            if(cur in summit) continue
            if(cost>costs[cur]) continue
            
            for((next,nextcost) in path[cur]){
                //가려는 곳이 출입구면 스킵
                if(next in gates) continue
                
                val newcost=maxOf(nextcost,cost)
                if(newcost>=costs[next]) continue
                costs[next]=newcost
                q.offer(Pair(next,newcost))
                
            }
        }
        
        val answers=ArrayList<Pair<Int,Int>>()
        summits.sort()
        for(i in summits){
            answers+=Pair(i,costs[i])
        }
        
        var minV=Int.MAX_VALUE
        var minI=0
        for((i,j) in answers){
            if(j<minV){
                minV=j
                minI=i
            }
        }
        answer+=minI
        answer+=minV


        
        return answer
    }
}



