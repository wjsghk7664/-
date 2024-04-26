class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(i:Int in left..right){
            if(num(i)){
                answer+=i
            }
            else{
                answer-=i
            }
        }
        return answer
    }
    
    fun num(tmp:Int):Boolean{
        var res:Int = 0
        for(i:Int in 1..tmp){
            if(tmp%i==0){
                ++res
            }
        }
        if(res%2==0){
            return true
        }
        else{
            return false
        }
    }
}

