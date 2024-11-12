class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var w = 0
        var h = 0
        for(i in sizes){
            val curw = maxOf(i[0],i[1])
            val curh = minOf(i[0],i[1])
            
            w = maxOf(curw,w)
            h = maxOf(curh,h)
        }
        return w*h
    }
}