class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        
        for(i in commands){
            answer+=getK(array,i)
        }
        
        return answer
    }
    
    fun getK(arr:IntArray, com:IntArray):Int{
        return arr.slice(com[0]-1..com[1]-1).sorted()[com[2]-1]
    }
}