class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        
        val arr=Array(n){ArrayList<Int>()}
        
        for(i in edge){
            arr[i[0]-1]+=i[1]-1
            arr[i[1]-1]+=i[0]-1
        }
        
        val visited=BooleanArray(n){false}
        val q=ArrayDeque<Pair<Int,Int>>()
        q.addLast(Pair(0,0))
        visited[0]=true
        
        var max=0
        var cnt=0
        while(q.isNotEmpty()){
            val (idx,len) = q.removeFirst()
            
            var isLeaf=true
            for(i in arr[idx]){
                if(!visited[i]){
                    q.addLast(Pair(i,len+1))
                    visited[i]=true
                    isLeaf=false
                }
            }
            
            if(isLeaf){
                if(len==max){
                    cnt++
                }else if(len>max){
                    cnt=1
                    max=len
                }
            }
        }
        
        return cnt
    }
}