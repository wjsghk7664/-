class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val total =hashMapOf<String,Int>()
        for((i,n) in genres.withIndex()){
            if(!total.contains(n)){
                total.put(n,0)
            }
            total[n]=total[n]!!+plays[i]
        }
        var list = mutableListOf<Pair<String, Int>>()
        for((k,v) in total){
            list+=Pair(k,v)
        }
        list = list.sortedByDescending{it.second}.toMutableList()
        println(list.toString())
        for(i in list){
            val gen = i.first
            var tmplist = mutableListOf<Pair<Int,Int>>()
            for((idx,n) in genres.withIndex()){
                if(n==gen){
                    tmplist+=Pair(idx, plays[idx])
                }
            }
            println(tmplist.toString())
            tmplist= tmplist.sortedByDescending{it.second}.toMutableList()
            answer+=if(tmplist.size>=2) tmplist.map{it.first}.slice(0..1) else tmplist.map{it.first}
        }
        return answer.toIntArray()
    }
}