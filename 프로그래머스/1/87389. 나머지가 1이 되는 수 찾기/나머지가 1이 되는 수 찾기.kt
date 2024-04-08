class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var check:Int
        var i:Int=1
        while(true){
            check=n%i
            if(check==1){break}
            ++i
        }
        answer=i
        return answer
    }
}