class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        
        //장르별로 나누기
        val map= HashMap<String,ArrayList<Pair<Int,Int>>>()
        
        for((idx,v) in genres.withIndex()){
            val list = map.getOrDefault(v,ArrayList<Pair<Int,Int>>())
            map.put(v,list.apply{add(Pair(idx,plays[idx]))})
            
        }
        //각 장르내의 앨범들을 재생횟수-인덱스 순으로 정렬해서 장르별 리스트를 결과에 넣기
        val result=ArrayList<List<Pair<Int,Int>>>()
        for((k,v) in map){
            result+=v.sortedWith(compareBy<Pair<Int,Int>>{-it.second}.thenBy{it.first})
        }
        //각 장르들을 총 재생횟수기준으로 정렬 
        result.sortByDescending{list -> list.map{it.second}.sum()}
        
        //각 장르별로 곡을 2개 이하씩만 뺀 뒤 flatten으로 한 리스트로 합친 뒤 각 곡의 인덱스만 남겨서 IntArray로 만든다.
        answer= result.map{it.slice(0..minOf(1,it.size-1))}.flatten().map{it.first}.toIntArray()
        
        return answer
    }
}