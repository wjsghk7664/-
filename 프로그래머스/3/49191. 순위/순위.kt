class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        //결과 기준으로 그래프 생성
        //이후 인접노드들 전부 갱신
        //A상대로 이겼으면 A가 이긴 상대에게도 전부 이김 =>head갱신
        //A상대로 졌으면 A가 진 상대에게도 전부 짐 =>tail갱신
        //head+tail size가 n이면 등수가 나옴
        
        val nodes=Array<Node>(n+1){Node(it)}
        
        for(i in results){
            nodes[i[0]].tail+=nodes[i[1]]
            nodes[i[1]].head+=nodes[i[0]]
        }
        
        for(i in nodes){
            for(j in i.head){
                j.tail.addAll(i.tail)
            }
            
            for(j in i.tail){
                j.head.addAll(i.head)
            }
        }
        
        for(i in nodes){
            if(i.head.size + i.tail.size == n-1) answer++
        }
        
        
        
        return answer
    }
}

class Node(val n:Int){
    val head=HashSet<Node>()
    val tail=HashSet<Node>()
}