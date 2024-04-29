class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = 0
        var total=0L
        
        for(i:Int in 1..count){
            total+=price*i
        }
        
        if(total>money){
            answer=total-money
        }
        else{
            answer=0L
        }
        return answer
    }
}