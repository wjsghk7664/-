class Solution {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        for(i:Int in 0..number.size-3){
            for(j:Int in i+1..number.size-2){
                for(k:Int in j+1..number.size-1){
                    if(number[i]+number[j]+number[k]==0){
                        answer+=1
                    }
                }
            }
        }
        return answer
    }
}