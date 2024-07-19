class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        return maxOf(find(arrayA,arrayB),find(arrayB,arrayA))
    }
    fun find(array1:IntArray, array2:IntArray):Int{
        val min=array1.minOrNull() as Int
        
        val fac=HashSet<Int>(min)
        
        
        for(i in 1..min){
            var flag=true
            for(j in array1){
                if(j%i!=0){
                    flag=false
                    break
                } 
            }
            if(flag) fac+=i
        }
        val removed=HashSet<Int>()
        for(i in fac){
            for(j in array2){
                if(j%i==0){
                    removed+=i
                    break
                }
            }
        }
        fac.removeAll(removed)
        return fac.maxOrNull()?: 0
    }
}