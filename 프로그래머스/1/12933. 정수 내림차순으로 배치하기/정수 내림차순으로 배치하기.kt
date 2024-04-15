class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var string = longArrayOf()
        var tmp=n
        while(tmp>0){
            string+=tmp%10
            tmp/=10
        }
        for(i:Int in 0..string.size-2){
            for(j:Int in 0..string.size-2){
                if(string[j]<string[j+1]){
                    var tmpp=string[j+1]
                    string[j+1]=string[j]
                    string[j]=tmpp
                }
            }
        }
        for(i:Int in 0..string.size-1){
            answer=answer*10 + string[i]
        }
        return answer
    }
}