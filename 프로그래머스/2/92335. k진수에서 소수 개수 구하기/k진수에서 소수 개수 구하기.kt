class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val longs=spl(n,k)
        if(longs.isEmpty()) return 0
        
        val prime=BooleanArray(longs.size){true}
        
        for(i in longs.indices){
            for(j in 2L..Math.sqrt(longs[i].toDouble()).toLong()){
                if(longs[i]/j!=1L&&longs[i]%j==0L){
                    prime[i]=false
                    break
                }
            }
        }
        for(i in prime){
            if(i) answer++
        }
        return answer
    }
    fun spl(n:Int, k:Int):List<Long>{
        var tmp=n
        val str=StringBuilder()
        while(tmp!=0){
            str.append(tmp%k)
            tmp/=k
        }
        return str.reverse().toString().split("0").filter{it!=""&&it!="1"}.map{it.toLong()}
    }
}