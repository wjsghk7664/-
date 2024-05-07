class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        var pnum=p.toLong()
        for(i:Int in 0..t.length-p.length){
            var tmp=t.substring(i,i+p.length).toLong()
            if(tmp<=pnum){
                answer+=1
            }
        }
        return answer
    }
}