class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        
        val list = IntArray(n+2){1}
        
        list[0]=0
        list[n+1]=0
        
        for(i in lost){
            list[i]-=1
        }
        
        for(i in reserve){
            list[i]+=1
        }
        
        for(i in 1..n){
            if(list[i]==0){
                if(list[i-1]==2){
                    list[i-1]=1
                    list[i]=1
                }else if(list[i+1]==2){
                    list[i+1]=1
                    list[i]=1
                }
            }
        }
        println(list.contentToString())
        for(i in list){
            
            if(i>0) answer++
        }
        
        
        return answer
    }
    
}