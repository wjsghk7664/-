class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        var cur=0
        var lists=hashMapOf<Int,Int>()
        for(i in tangerine){
            if(lists[i]!=null){
                lists[i]=lists[i]!!.plus(1)
            }else{
                lists.put(i,1)
            }
        }
        var valueList=lists.values.toList().sortedDescending()

        var total=0
        for(i in valueList){
            total+=i
            answer++
            if(total>=k) break
        }
        
        
        return answer
    }
}