class Solution {
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val hashSet=HashSet<Pair<Int,Int>>()
        for(i in maps.indices){
            for(j in maps[0].indices){
                hashSet.add(Pair(i,j))
            }
        }
        val di=intArrayOf(0,0,1,-1)
        val dj=intArrayOf(1,-1,0,0)
        
        val q=ArrayDeque<Pair<Int,Int>>()
        var sum=0
        while(hashSet.isNotEmpty()||q.isNotEmpty()){
            var flag=false
            val (curi,curj)=if(q.isEmpty()) {
                val tmp=hashSet.first()
                hashSet.remove(tmp)
                tmp
            } else{
                flag=true
                q.removeFirst()
            } 
            
            if(maps[curi][curj]=='X') continue
            
            if(flag){
                sum+=maps[curi][curj].toString().toInt()
            }
            else{
                if(sum!=0) answer+=sum
                sum=maps[curi][curj].toString().toInt()
            }
            
            for(i in 0..3){
                val tmp=Pair(curi+di[i],curj+dj[i])
                if(hashSet.contains(tmp)&&maps[tmp.first][tmp.second]!='X'){
                    hashSet.remove(tmp)
                    q.addLast(tmp)
                }
            }
        }
        //마지막 남은 sum처리
        if(sum!=0) answer+=sum
        answer.sort()
        if(answer.isEmpty()) answer+=-1
        
        return answer
    }
}