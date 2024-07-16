class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0

        val arr=Array(N){IntArray(N){Int.MAX_VALUE}}
        
        for(i in road){
            arr[i[0]-1][i[1]-1]=minOf(i[2],arr[i[0]-1][i[1]-1])
            arr[i[1]-1][i[0]-1]=minOf(i[2],arr[i[1]-1][i[0]-1])
        }
        
        val q=ArrayDeque<Int>()
        val visited=BooleanArray(N){false}
        val min=IntArray(N){Int.MAX_VALUE}
        
        q.addLast(0)
        min[0]=0
        
        while(true){
            val cur=q.removeFirst()
            visited[cur]=true
            
            for((i,v) in arr[cur].withIndex()){
                if(!visited[i]&&v!=Int.MAX_VALUE){
                    min[i]=minOf(min[cur]+v,min[i])
                }
            }
            
            var minV=Int.MAX_VALUE
            var minI=-1
            for((i,v) in min.withIndex()){
                if(!visited[i]&&v<minV){
                    minV=v
                    minI=i
                }
            }
            if(minI==-1) break
            q.addLast(minI)
        }
        
        for(i in min){
            if(i<=k) answer++
        }

        return answer
    }
}