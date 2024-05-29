class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        var charList=mutableListOf<Char>()
        var charMap=mutableMapOf<Char,Int>()
        var idx=0
        for(i:Char in 'a'..'z'){
            if(!skip.contains(i)){
                charList+=i
                charMap.put(i,idx)
                ++idx
            }
        }
        
        for(i:Char in s){
            var tmp=charMap[i]?:throw IllegalArgumentException()
            tmp+=index
            var cSize=charList.size
            if(tmp>=cSize){
                tmp%=cSize
            }
            answer+=charList[tmp]
        }
        
        return answer
    }
}