class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var tmp=1
        while(tmp<=n){
            if(n%tmp==0){
                answer+=tmp
            }
            tmp++
        }
        return answer
    }
}