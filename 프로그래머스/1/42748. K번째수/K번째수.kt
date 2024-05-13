class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for(i:Int in 0..commands.size-1){
            answer+=getK(array,commands[i])
        }
        return answer
    }
    
    fun getK(arr: IntArray, command:IntArray):Int{
        var tmp=arr.sliceArray(command[0]-1..command[1]-1)
        tmp=tmp.sortedArray()
        return tmp[command[2]-1]
    }
}