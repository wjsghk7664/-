class Solution {
    fun solution(numbers: IntArray): String {
        if(numbers.sum()==0) return "0"
 
        var num=Array(numbers.size){Pair(-1,-1)} //바꾼수, 원래수
        for((idx,i) in numbers.withIndex()){
            if(i<10){
                num[idx]=Pair(111111*i,i)
            }else if(i<100){
                num[idx]=Pair(10101*i,i)
            }else if(i<1000){
                num[idx]=Pair(1001*i,i)
            }else{
                num[idx]=Pair(i,i)
            }
        }
        return num.sortedByDescending{it.first}.map{it.second.toString()}.joinToString().replace(", ","")
        
    }
}