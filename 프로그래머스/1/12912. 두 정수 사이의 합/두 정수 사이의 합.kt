class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        var max=a.toLong()
        var min=b.toLong()
        if(a<b){
            var tmp=max
            max=min
            min=tmp
        }
        for(i:Long in min..max){
            answer+=i
        }
        return answer
    }
}