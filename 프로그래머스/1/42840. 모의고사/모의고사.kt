class Solution {
    fun solution(answers: IntArray): IntArray {
        val a = intArrayOf(1,2,3,4,5)
        val b = intArrayOf(2,1,2,3,2,4,2,5)
        val c = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        
        var ares = 0
        var bres = 0
        var cres = 0
        
        for((i,v) in answers.withIndex()){
            var cura = a[i%a.size]
            var curb = b[i%b.size]
            var curc = c[i%c.size]
            
            if(cura==v) ares++
            if(curb==v) bres++
            if(curc==v) cres++
        }
        
        var answer = intArrayOf()
        
        val max = maxOf(ares,bres,cres)
        
        if(max == ares) answer+=1
        if(max == bres) answer+=2
        if(max == cres) answer+=3
        
        return answer
    }
}