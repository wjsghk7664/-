class Solution {
    fun solution(n: Int, start: Int, end: Int, roads: Array<IntArray>, trap: IntArray): Int {
        var answer: Int = -1
        val road=Array(n+1){ArrayList<IntArray>()} //인덱스는 한쪽 연결점. 배열은 3짜리: 반대연결점, weight, 화살표(1안,0바깥)
        for(i in roads){
            road[i[0]]+=intArrayOf(i[1],i[2],0)
            road[i[1]]+=intArrayOf(i[0],i[2],1)
        }
        for(i in road){
            i.sortBy{it[1]}
        }
        val traps=HashSet<Int>()
        for(i in trap) traps.add(i)
        
        //BFS로 탐색해서 제일먼저 들어오면 중지
        val q=ArrayDeque<Node>()
        val first=Node(start)
        for(i in traps){
            first.traps.put(i,0)
        }
        q.addLast(first)
        
        var min=Int.MAX_VALUE
        while(q.isNotEmpty()){
            val cur=q.removeFirst()
            
            //end에 도달했으면 최솟값갱신
            if(cur.n==end) min=minOf(min,cur.total)
            
            //현재위치가 트랩이고 밟은 횟수가 3이면 스킵
            if(cur.traps[cur.n]==3) continue
            
            //현재까지 값이 min이상이면 탐색할 필요없음
            if(cur.total>=min) continue
            
            //현재 밟은 곳이 한번 밟은 트랩인지 체크-1
            //i로 연결된곳이 한번 밟은 트랩인지 체크-2
            //해당없으면 정상 진행
            //1만 해당되면 화살표 반대것만 타고 감
            //2만 해당되면 화살표 반대것을 타고감
            //1,2 둘다 해당되면 원래것을 타고 감
            //트랩 체크후 추가
            val flag1=cur.traps[cur.n]==1
            for(i in road[cur.n]){
                val flag2=cur.traps[i[0]]?:0 ==1
                
                val node=cur.copy(i[0])
                if((flag1&&!flag2)||(flag2&&!flag1)){
                    if(i[2]==1){
                        //밟은 곳이 트랩일때 횟수 증가
                        if(traps.contains(i[0])){
                            node.traps.put(i[0],node.traps[i[0]] as Int +1)
                        }
                        node.total+=i[1]
                        q.addLast(node)
                    }
                }else{
                    if(i[2]==0){
                        //밟은 곳이 트랩일때 횟수 증가
                        if(traps.contains(i[0])){
                            node.traps.put(i[0],node.traps[i[0]] as Int +1)
                        }
                        node.total+=i[1]
                        q.addLast(node)
                    }
                }
            }
        }
        return min
    }
}

class Node(val n:Int){
    val traps=HashMap<Int,Int>()
    var total=0
    
    fun copy(m:Int):Node{
        val new =Node(m)
        new.total=this.total
        for((i,j) in this.traps){
            new.traps.put(i,j)
        }
        return new
    }
}