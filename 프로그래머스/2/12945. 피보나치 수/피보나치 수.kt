class Solution {
    fun solution(n: Int): Int {
        return matmult(n)%1234567
    }
    
    fun matmult(n:Int):Int{
        var tmp=arrayOf(arrayOf(1,1),arrayOf(1,0))
        for(i in 1..n-1){
            tmp=arrayOf(arrayOf(tmp[0][0]+tmp[0][1],tmp[0][0]),
                       arrayOf(tmp[1][0]+tmp[1][1],tmp[1][0]))
            if(tmp[1][1]>1234567){
                for(j in 0..1){
                    for(k in 0..1){
                        tmp[j][k]%=1234567
                    }
                }
            }
        }
        return tmp[1][0]
    }
}