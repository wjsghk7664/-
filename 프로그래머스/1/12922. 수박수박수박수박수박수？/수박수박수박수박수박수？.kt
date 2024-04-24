class Solution {
    fun solution(n: Int): String {
        var answer = ""
        for(i:Int in 0..n-1){
            if(i%2==0){
                answer+="수"
            }
            else{
                answer+="박"
            }
        }
        return answer
    }
}