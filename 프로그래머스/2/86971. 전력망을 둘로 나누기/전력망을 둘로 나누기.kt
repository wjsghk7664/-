class Solution {
    lateinit var tree:Array<IntArray>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = -1
        tree=Array(n){IntArray(n)}
        for(i in wires){
            tree[i[0]-1][i[1]-1]=1
            tree[i[1]-1][i[0]-1]=1
        }
        
        var minValue=Int.MAX_VALUE
        for(i in 0..n-1){
            val visited=BooleanArray(n){false}
            visited[i]=true
            var min=Int.MAX_VALUE
            for((idx,v) in tree[i].withIndex()){
                if(v==1){
                    visited[idx]=true
                    val tmp=TreeSum(idx,visited)
                    min=minOf(min, Math.abs(n-2*tmp))
                }
            }
            minValue=minOf(min,minValue)
            
        }
        return minValue
    }
    fun TreeSum(n:Int, visited:BooleanArray):Int{
        var result=1
        var checkleaf = true
        for((i,v) in tree[n].withIndex()){
            if(v==1&&!visited[i]){
                checkleaf=false
                visited[i]=true
                result+=TreeSum(i,visited)
            }
        }
        if(checkleaf){
           return 1 
        } 
        return result
    }
}