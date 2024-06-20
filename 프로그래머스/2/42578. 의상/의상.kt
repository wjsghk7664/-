class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        
        val map = hashMapOf<String,ArrayList<String>>()
        for(i in clothes){
            if(!map.keys.contains(i[1])){
                map.put(i[1],ArrayList<String>())   
            }
            map[i[1]]?.add(i[0])
        }
        for((key,value) in map){
            answer*=value.size+1
        }
        
        return answer-1
    }
}