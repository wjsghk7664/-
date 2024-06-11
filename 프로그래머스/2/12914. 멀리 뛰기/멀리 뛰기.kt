class Solution {
    fun solution(n: Int): Long {
        val tmp=ArrayList<Long>()
        tmp+=1
        tmp+=2
        tmp+=3
        if(n<=3) return tmp[n-1]
        for(i:Int in 4..n){
            val tmpp:Long=tmp[2]
            tmp[2]=tmp[2]+tmp[1]
            tmp[0]=tmp[1]
            tmp[1]=tmpp
            tmp[2]%=1234567L
        }
        return tmp[2]
    }
}
