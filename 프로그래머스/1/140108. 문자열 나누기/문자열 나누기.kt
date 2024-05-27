class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        answer=sep(s)
        
        return answer
    }
    
    fun sep(s:String):Int{
        
        if(s.length==1){
            return 1
        }
        if(s.length==0){
            return 0
        }
        
        var first=1
        var others=0
        
        var fChar=s[0]
        var idx=1
        
        while(first!=others&&idx<s.length){
            if(s[idx]!=fChar){
                others++
            }
            else{
                first++
            }
            idx++
        }
        
        if(idx==s.length){
            return 1
        }
        
        return 1+sep(s.substring(idx))
        
    }
}