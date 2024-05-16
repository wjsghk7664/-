class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var oner=intArrayOf()
        var min=score[0]
        var len=0
        if(k<score.size){
            len=k-1
        }
        else{
            len=score.size-1
        }
        for(i:Int in 0..len){
            oner+=score[i]
            if(score[i]<min){
                min=score[i]
            }
            answer+=min
        }
        
        oner=oner.sortedArray()
        
        if(k<score.size){
            for(i:Int in k..score.size-1){
                if(score[i]>min){
                    oner=oner.sliceArray(1..oner.size-1)
                    oner+=score[i]
                    oner=oner.sortedArray()
                    min=oner[0]
                }
                answer+=min
            }
        }
        return answer
    }
}