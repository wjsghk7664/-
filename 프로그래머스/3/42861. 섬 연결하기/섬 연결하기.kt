class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        //MST
        val arr = Array(n){ArrayList<Pair<Int,Int>>()} //v1:v2,cost
        
        for(i in costs){
            arr[i[0]]+=Pair(i[1],i[2])
            arr[i[1]]+=Pair(i[0],i[2])
        }
        
        val vertex=HashSet<Int>()
        
        vertex+=0
        
        
        while(vertex.size!=n){
            var min=Int.MAX_VALUE
            var minNode=0
            for(i in vertex){
                for((node,cost) in arr[i]){
                    if(!vertex.contains(node)&&cost<min){
                        minNode=node
                        min=cost
                    }
                }
            }
            vertex+=minNode
            answer+=min
        }
        
        return answer
    }
}