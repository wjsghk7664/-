class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer=0

        var q1sum=queue1.map{it.toLong()}.sum()
        var target=(q1sum+queue2.map{it.toLong()}.sum())
        if(target%2!=0L) return -1
        target/=2
        
        var left=0
        var right=queue1.size
        
        val q=queue1+queue2
        
        while(left<q.size&&right<q.size){
            if(q1sum==target) return answer
            if(q1sum<target){
                q1sum+=q[right++]
                answer++
            }else{
                q1sum-=q[left++]
                answer++
            }
        }
        return -1
       
    }
}