class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        
        //기준: 각 심사관별 총 심사시간중 최대값이 최소가 되는 것
        //총 심사시간: 인원을 분배하여 심사기간에 곱해준다.
        //최대 시간은 심사관 최대시간*입국심사 기다리는 전체 인원수
        //각 루프별로 체크해서 최대시간을 이진 탐색으로 찾아간다.
        
        times.sort()
        
        var left=0L
        var right=times.last()*n.toLong()
        
        while(left<right){
            val mid=(left+right)/2L
            var total = 0L
            
            //최대값 이하중 최대가 되도록 인원분배
            for(i in times){
                total+=mid/i.toLong()
            }
            
            //총 인원수와 같으면 최대값을 더 내렸을때 총인원수가 같을수 있다
            //예를 들어 [3,5] 11이면 3명 2명으로 총 5명인데 10이면 3명 2명으로 여전히 5명임
            if(total==n.toLong()){
                right=mid
            } 
            //총 인원수가 n보다 작으면 최대값을 늘려야 한다
            else if(total<n.toLong()){
                left=mid+1
            } 
            //총 인원수가 n보다 크면 최대값을 줄여야 한다.
            else{
                right=mid
            }
        }
        
        
        return right
    }
}