class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var tmp=storey
        while(tmp>0){
            val cur=tmp%10
            val next=tmp%100 - cur
            if((cur==5&&next>=50)||cur>5){
                answer+=10-cur
                tmp+=10
            } 
            else answer+=cur
            tmp/=10
        }
        return answer
    }
}