class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = ""
        var count = 0
        while(true){
            if(seoul[count]=="Kim"){
                break
            }
            count++
        }
        answer="김서방은 ${count}에 있다"
        return answer
    }
}