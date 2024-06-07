class Solution {
    fun solution(s: String): String {
        var tmp=s.split(" ")
        var result=mutableListOf<String>()
        for(i in tmp){
            if(i==""){
                result+=i
            }else{
                result+=i[0].uppercase()+i?.substring(1)?.lowercase()
            }
        }
        return result.joinToString().replace(",","")
    }
}