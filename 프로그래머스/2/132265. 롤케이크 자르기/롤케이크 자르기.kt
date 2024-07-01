class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val forward=IntArray(topping.size)
        val backward=IntArray(topping.size)
        val types=HashSet<Int>()
        for(i in topping.indices){
            types.add(topping[i])
            forward[i]=types.size
        }
        types.clear()
        for(i in topping.size-1 downTo 0){
            types.add(topping[i])
            backward[i]=types.size
        }
        for(i in 0..forward.size-2){
            if(forward[i]==backward[i+1]) answer++
        }
        
        return answer
    }
}