class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        for(i:Int in 0..s.length-1){
            answer+=findIdx(s,s[i],i)
        }
        return answer
    }
    
    fun findIdx(s:String, al:Char, cur:Int):Int{
        if(cur==0){
            return -1
        }
        var idx=-1
        for(i:Int in 0..cur-1){
            if(s[i]==al){
                idx=cur-i
            }
        }
        return idx
    }
}