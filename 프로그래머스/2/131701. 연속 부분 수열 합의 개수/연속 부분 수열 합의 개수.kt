class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0
        var nums=hashSetOf<Int>()
        for(i in 1..elements.size){
            
            for(j in elements.indices){
                var sum=0
                var idx=j
                repeat(i){
                    sum+=elements[(idx)%elements.size]
                    ++idx
                    idx%=elements.size
                }
                nums.add(sum)
            }
            
        }
        return nums.size
    }
}