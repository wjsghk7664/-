class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        
        var idx = 1
        val qPro = ArrayDeque<Int>()
        for(i in progresses){
            qPro.addLast(i)
        }
        
        while(qPro.isNotEmpty()){
            for(i in idx-1 .. speeds.size-1){
                qPro[i-idx+1]+=speeds[i]
            }
            var num = 0
            while(true){
                if(qPro.size==0) break
                if(qPro[0]>=100){
                    qPro.removeFirst()
                    num++
                    idx++
                }else{
                    break
                }
            }
            if(num>0){
                answer+=num
            }
        }
        
        return answer
    }
}