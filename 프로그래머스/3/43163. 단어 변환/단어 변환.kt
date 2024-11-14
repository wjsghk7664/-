class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = Int.MAX_VALUE
        
        if(!words.contains(target)) return 0
        
        val q = ArrayDeque<Pair<String,Int>>()
        val visited = BooleanArray(words.size){false}
        
        q.addLast(Pair(begin,0))
        if(words.contains(begin)) visited[words.indexOf(begin)]=true
        
        while(q.isNotEmpty()){
            val (cur,idx) = q.removeFirst()
            
            if(cur==target){
                answer=idx
                break
            }
            
            val next = findword(cur,words)
            for(i in next){
                if(!visited[words.indexOf(i)]){
                    visited[words.indexOf(i)]=true
                    q.addLast(Pair(i,idx+1))
                }
            }
        }
        return answer
        
    }
    
    fun findword(cur:String, words:Array<String>):Array<String>{
        var result = arrayOf<String>()
        
        for(i in words){
            var diff=0
            for(j in cur.indices){
                if(cur[j]!=i[j]) diff++
            }
            if(diff==1) result+=i
        }
        return result
    }
}