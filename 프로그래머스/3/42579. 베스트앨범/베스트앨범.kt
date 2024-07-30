class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        
        //장르별로 나누기
        
        val map= HashMap<String,List<Pair<Int,Int>>>()
        
        for((idx,v) in genres.withIndex()){
            val list = map.getOrDefault(v,listOf())
            map.put(v,listOf(list,listOf(Pair(idx,plays[idx]))).flatten())
            
        }
        val result=ArrayList<List<Pair<Int,Int>>>()
        for((k,v) in map){
            result+=v.sortedWith(compareBy<Pair<Int,Int>>{-it.second}.thenBy{it.first})
        }
        result.sortByDescending{list -> list.map{it.second}.sum()}
        answer= result.map{it.slice(0..minOf(1,it.size-1))}.flatten().map{it.first}.toIntArray()
        
        return answer
    }
}