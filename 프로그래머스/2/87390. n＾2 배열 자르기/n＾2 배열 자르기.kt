class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()
        
        
        for(i in left..right){
            if(i/n.toLong()>=i%n.toLong()){
                answer+=(i/n.toLong() + 1L).toInt()
            }else{
                answer+=(i%n.toLong() + 1L).toInt()
            }
        }
        
        return answer
    }
}