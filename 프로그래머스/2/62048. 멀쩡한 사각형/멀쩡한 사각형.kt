class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        for(i in 0..w-1){
            val prev=(h.toLong()*i.toLong())/w.toLong()
            val end=ceil(i.toLong()+1L,w.toLong(),h.toLong())
            answer+=end-prev
            
        }
        return w.toLong()*h.toLong()-answer
    }
    
    fun ceil(x:Long,w:Long,h:Long):Long{
        var result=(h*x)/w
        if((h*x)%w!=0L) result++
        return result
    }
}