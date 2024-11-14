class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        
        costs.sortBy{it[2]}
        
        val root = IntArray(n){it}
        
        for(i in costs){
            val roota = findRoot(i[0],root)
            val rootb = findRoot(i[1],root)
            
            if(roota==rootb) continue
            
            root[roota]=rootb
            answer+=i[2]
            
        }
        
        return answer
    }
    
    fun findRoot(a:Int, roots:IntArray):Int{
        var inita=a
        while(inita!=roots[inita]){
            inita=roots[inita]
        }
        return inita
    }
}