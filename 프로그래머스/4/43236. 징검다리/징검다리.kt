class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0

        rocks.sort()
        
        val dist=ArrayList<Int>()
        dist+=rocks[0]
        for(i in 0..rocks.size-2){
            dist+=rocks[i+1]-rocks[i]
        }
        dist+=distance-rocks[rocks.size-1]
        
        var left=0
        var right=distance+1
        
        while(left<right){
            val mid=(left+right)/2
            
            var total=0
            var removed=0
            
            for(i in dist){
                total+=i //앞에서부터 돌이 제거될때마다 처음부터 첫돌사이까지의 거리
                
                //최소거리인 mid가 되기전까지 돌 제거
                //최소거리를 만족하면 돌을 제거하지 않고 다음 돌부터 다시 제거 
                //이때 total은 제거되지 않은 돌부터 다음 첫돌까지 거리
                if(total<mid){
                    removed++
                }else{
                    total=0
                }
            }
          
            if(n>removed){//돌을 더 제거해야 하므로 우측 범위 선택
                left=mid+1

            }else if(n<removed){//돌을 덜 제거해야 하므로 좌측 범위 선택
                right=mid
         
            }else{//순차적으로 제거한 결과 나온 최소거리이므로 최적의 경우엔 최소거리가 더 커질 가능성이 있다. 즉 우측 범위 선택
                left=mid+1
 
            }
        }
        
        return left-1
    }
    
    
}

