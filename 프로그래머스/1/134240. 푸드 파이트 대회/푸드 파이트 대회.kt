class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        for(i:Int in 1..food.size-1){
            for(j:Int in 1..food[i]/2){
                answer+=i
            }
        }
        answer+='0'
        answer+=inv(answer)
        return answer
    }
    
    fun inv(s:String):String{
        var tmp=""
        for(i:Int in 0..s.length-2){
            tmp+=s[s.length-2-i]
        }
        return tmp
    }
}