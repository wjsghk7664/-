class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        arr.forEach{
            if(it%divisor==0){
                answer+=it
            }
        }
        if(answer.size==0){
            answer+=-1
        }
        else if(answer.size>1){
            for(i:Int in 0..answer.size-2){
                for(j:Int in 0..answer.size-2){
                    if(answer[j]>answer[j+1]){
                        var tmp=answer[j]
                        answer[j]=answer[j+1]
                        answer[j+1]=tmp
                    }
                }
            }
        }
        return answer
    }
}