class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        answer+=numbers[0]+numbers[1]
        for(i:Int in 0..numbers.size-2){
            for(j:Int in i+1..numbers.size-1){
                var tmp=numbers[i]+numbers[j]
                if(!checkDup(answer,tmp)){
                    answer+=tmp
                }
            }
        }
        return answer.sortedArray()
    }
    
    fun checkDup(array:IntArray, num:Int):Boolean{
        for(i:Int in 0..array.size-1){
            if(array[i]==num){
                return true
            }
        }
        return false
    }
}