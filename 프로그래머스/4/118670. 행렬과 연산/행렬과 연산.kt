class Solution {
    fun solution(rc: Array<IntArray>, operations: Array<String>): ArrayDeque<ArrayDeque<Int>> {
        var answer: Array<IntArray> = arrayOf<IntArray>()
        
        var left=ArrayDeque<Int>()
        var right=ArrayDeque<Int>()
        var middle=ArrayDeque<ArrayDeque<Int>>()
        
        
        val wEnd=rc[0].size-1
        for(i in rc.indices){
            left.addLast(rc[i][0])
            right.addLast(rc[i][wEnd])
            var tmpDeque=ArrayDeque<Int>()
            for(j in 1..wEnd-1){
                tmpDeque.addLast(rc[i][j])
            }
            middle.addLast(tmpDeque)
        }
        
        for(i in operations){
            if(i=="Rotate"){
                middle[0].addFirst(left.removeFirst())
                right.addFirst(middle[0].removeLast())
                middle[middle.size-1].addLast(right.removeLast())
                left.addLast(middle[middle.size-1].removeFirst())
            }else{
                middle.addFirst(middle.removeLast())
                left.addFirst(left.removeLast())
                right.addFirst(right.removeLast())
            }
        }
        
        /*
        for(i in rc.indices){
            var tmparr=intArrayOf()
            tmparr+=left.removeFirst()
            tmparr+=middle.removeFirst().toIntArray()
            tmparr+=right.removeFirst()
            answer+=tmparr
        }
        */
        
        for(i in middle.indices){
            middle[i].addFirst(left.removeFirst())
            middle[i].addLast(right.removeFirst())
        }
        
        
        
        return middle
        
    }
}