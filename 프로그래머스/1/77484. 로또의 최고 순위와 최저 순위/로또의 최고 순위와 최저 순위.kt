class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var results=equals(lottos,win_nums)
        answer+=7-results[0]
        answer+=7-results[0]-results[1]
        if(answer[0]==7){
            answer[0]=6
        }
        if(answer[1]==7){
            answer[1]=6
        }
        if(answer[1]<answer[0]){
            var tmp=answer[1]
            answer[1]=answer[0]
            answer[0]=tmp
        }
        return answer
    }
    
    fun equals(l:IntArray, win:IntArray):IntArray{
        var result=0
        var zeros=0
        for(i:Int in 0..l.size-1){
            if(win.contains(l[i])){
                result++
            }
            if(l[i]==0){
                zeros++
            }
        }
        return intArrayOf(result,zeros)
    }
}