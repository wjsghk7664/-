class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = LongArray(numbers.size)
        
        for((i,v) in numbers.withIndex()){
            answer[i]=Find(v)
        }
        
        
        
        return answer
    }
    //2진수로 변환. 큐에 넣음(현재값, 바꾼개수, 바꾼위치)
    //하나만 바꾸고 넣음-처음인덱스부터 원본수 최대위치보다 한자리큰 위치까지
    //체크-원본수보다 큰지: 큰데 min보다 크면 스킵,큰데 min보다 작거나 같을시 min갱신 후 두번째 비트 바꿔 큐에 넣기
    //체크-원본수보다 작은지: 두번째 비트 바꿔 큐에 넣음
    //체크-원본수보다 큰지:min갱신 그리고 크든 작든 continue
    fun Find(n:Long):Long{
        var max=0
        var tmp=n
        while(tmp!=0L){
            tmp/=2L
            max++
        }
        
        val nstr=n.toString(2).reversed()+"0"
        
        val q=ArrayDeque<Triple<Long,Int,Int>>()
        q.addLast(Triple(n,0,-1))
        
        var min=Long.MAX_VALUE
        while(q.isNotEmpty()){
            val (cur,num,idx)=q.removeFirst()
            if(num==1){
                if(cur>n){
                    if(cur>min) continue
                    else min=cur
                }
            }
            if(num==2){
                if(cur>n) min=minOf(cur,min)
                continue
            }
            
            if(num<2){
                var pow=1L
                for(i in 0..max){
                    if(i==idx){
                        pow*=2L
                        continue
                    } 
                    if(nstr[i]=='1'){
                        q.addLast(Triple(cur-pow,num+1,i))
                    }else{
                        q.addLast(Triple(cur+pow,num+1,i))
                    }
                    pow*=2L
                    
                }
            }
        }
        return min
   
    }
}