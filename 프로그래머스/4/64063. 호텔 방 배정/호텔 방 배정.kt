class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        var answer = LongArray(room_number.size)
        
        val assigned=HashMap<Long,Long>()
        
        
        //방을 추가시에는 키는 배정된 방, 값은 빈방
        //키로 체크해서 배정된 방이 아니면 키+1로 맵에 넣어줌
        //키로 체크해서 배정된 방이면 배정된 방들목록을 모아두면서 다음방으로 넘어감
        //배정되지 않은 방이 나오면 배정해줌(마찬가지로key,key+1)
        //모아둔 방들의 값도 전부 key+1로 갱신
        for((i,value) in room_number.withIndex()){
            var v=value
            val tmpset=HashSet<Long>()
            while(assigned.containsKey(v)){
                tmpset.add(v)
                v=assigned[v] as Long
            }
            for(j in tmpset){
                assigned.put(j,v+1)
            }
            assigned.put(v,v+1)
            answer[i]=v
        }
        
        
        
        
        return answer
    }
}