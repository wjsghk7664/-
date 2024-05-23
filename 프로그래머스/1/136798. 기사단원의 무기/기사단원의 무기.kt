class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        for(i:Int in 1..number){
            var divN=divNum(i)
            if(divN>limit){
                answer+=power
            }
            else{
                answer+=divN
            }
        }
        return answer
    }
    
    fun divNum(n:Int):Int{
        var result = 0
        var i:Int = 1
        if(n==1){
            return 1
        }
        while(i*i<n){
            if(n%i==0){
                result+=2
            }
            ++i
        }
        if(i*i==n){
            result++
        }
        return result
    }
}