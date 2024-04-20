class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        for(i:Int in 0..phone_number.length-5){
            answer+="*"
        }
        for(i:Int in phone_number.length-4..phone_number.length-1){
            answer+=phone_number[i]
        }
        return answer
    }
}