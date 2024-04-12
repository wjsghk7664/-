class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var tmp=n
        var i:Long=1
        while(i<=n/2){
            var m=tmp/i
            var k=tmp%i
            if(m==i&&k==0.toLong()){
                answer=m
                break
            }
            ++i
        }
        if(n==1.toLong()){
            answer=1
        }
        if(answer==0.toLong()){
            answer=-1
        }
        else{
            answer=(answer+1)*(answer+1)
        }
        
        return answer
    }
}