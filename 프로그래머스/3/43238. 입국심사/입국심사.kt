class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        
        //총 심사시간으로 이진탐색
       
        
        times.sort()
        
        var left = 0L
        var right = n.toLong()*times.last().toLong()
        
        while(left<right){
            var total = 0L
            val mid = (left+right)/2L
            
            //주어진 시간 mid동안 각 심사관이 심사할수있는 인원수를 구해 더해줌
            for(i in times){
                total+=mid/i.toLong()
            }
            
            //총 인원수가 n보다 크면 시간을 줄임
            if(total>n.toLong()){
                right = mid
            }else if(total<n.toLong()){
                left = mid+1
            }
            //총 인원수가 n과 같으면 최대값을 내려도 같을 수 있음
            //mid가 11 [3,5]일시 인원수는 3,2로 5명인데 10 [3,5]여도 3,2로 5명 
            else{
                right = mid
            }
        }
        
        return left
    }
}