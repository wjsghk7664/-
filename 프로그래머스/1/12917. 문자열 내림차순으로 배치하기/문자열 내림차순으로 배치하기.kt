class Solution {
    fun solution(s: String): String {
        var answer = ""
        var upper=""
        var lower=""
        
        for(i:Int in 0..s.length-1){
            if(s[i].isUpperCase()){
                upper+=s[i]
            }
            else{
                lower+=s[i]
            }
        }
        upper=upper.split("").sorted().reversed().joinToString("")
        lower=lower.split("").sorted().reversed().joinToString("")
        answer+=lower
        answer+=upper
        
        return answer
    }
}