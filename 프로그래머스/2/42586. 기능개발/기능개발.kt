class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        
        var idx=0
        
        while(idx<progresses.size){
            if(idx==progresses.size-1){
                answer+=1
                break
            }
            var flag=true //앞 작업중 완료안된게 있으면 false
            var sum=1
            val mult=(100-progresses[idx])/speeds[idx] + if(progresses[idx]%speeds[idx]!=0) 1 else 0
            for(i in idx+1..progresses.size-1){
                progresses[i]+=mult*speeds[i]
                if(progresses[i]>=100&&flag){
                    sum++
                    idx++
                }
                else{
                    flag=false
                }
            }
            idx++
            answer+=sum
            
        }
        return answer
    }
}