class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var tmpsizes=sizes
        for(i:Int in 0..tmpsizes.size-1){
            if(tmpsizes[i][0]<tmpsizes[i][1]){
                val tmp=tmpsizes[i][0]
                tmpsizes[i][0]=tmpsizes[i][1]
                tmpsizes[i][1]=tmp
            }
        }
        var maxw=tmpsizes[0][0]
        var maxh=tmpsizes[0][1]
        for(i:Int in 0..tmpsizes.size-1){
            if(tmpsizes[i][0]>maxw){
                maxw=tmpsizes[i][0]
            }
            if(tmpsizes[i][1]>maxh){
                maxh=tmpsizes[i][1]
            }
        }
        answer=maxh*maxw
        return answer
    }
}