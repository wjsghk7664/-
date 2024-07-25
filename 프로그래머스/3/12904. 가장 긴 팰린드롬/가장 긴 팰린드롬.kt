class Solution {
    fun solution(s: String): Int {
        var answer = 0
        
        var max = 0 
        
        for(i in s.indices){
            var f=i
            var b=i
            var len=1
            while(f in 0..s.length-1&&b in 0..s.length-1&&s[f]==s[b]){
                f--
                b++
                len+=2
            }
            max = maxOf(max,len)
            f=i
            b=i+1
            len=2
            while(f in 0..s.length-1&&b in 0..s.length-1&&s[f]==s[b]){
                f--
                b++
                len+=2
            }
            max = maxOf(max,len)
        }
        

        return max-2
    }
}