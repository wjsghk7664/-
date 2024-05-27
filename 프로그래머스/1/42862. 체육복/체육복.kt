class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var list = MutableList<Int>(n+2, {i->1})
        var lost=lost.sortedArray()
        list[0]=0
        list[n+1]=0
        
        for(i:Int in 0..reserve.size-1){
            list[reserve[i]]+=1
        }
        for(i:Int in 0..lost.size-1){
            list[lost[i]]-=1
        }
        for(i:Int in 0..lost.size-1){
            var tmp=lost[i]
            if(list[tmp-1]==2){
                list[tmp]=1
                list[tmp-1]=1
            }
            else if(list[tmp+1]==2){
                list[tmp]=1
                list[tmp+1]=1
            }
        }
        
        for(i:Int in 1..n){
            if(list[i]>0){
                answer++
            }
        }
        
        return answer
    }
    
}