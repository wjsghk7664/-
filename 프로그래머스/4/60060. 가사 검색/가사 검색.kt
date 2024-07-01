class Solution {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        //words의 각 단어를 정순, 역순으로 두개 집합을 둔다.
        //각각 trie에 집어넣음
        //앞이 물음표이면 역순 비교, 뒤가 물음표이면 정순 비교
        
        //개수별로 정순 역순 문자열들을 모아둠
        //nodes[i][j]:i는 문자 길이, j는 0은 정순, 1은 역순
        //자기자리 찾아 내려가면서 1씩 더해 하위트리의 총 단어수를 저장해둠
        val nodes=Array(10001){Array(2){Node()}}
        for(i in words){
            
            var curNode=nodes[i.length][0]
            curNode.total++
            for((idx,j) in i.withIndex()){
                if(curNode.child.keys.contains(j)){
                    curNode=curNode.child[j] as Node
                    curNode.total++
                }else{
                    val node=Node()
                    curNode.child.put(j,node)
                    curNode=node
                    node.total++
                }
            }
        }
        
        for(j in words){
            val i=j.reversed()
            var curNode=nodes[i.length][1]
            curNode.total++
            for((idx,j) in i.withIndex()){
                if(curNode.child.keys.contains(j)){
                    curNode=curNode.child[j] as Node
                    curNode.total++
                }else{
                    val node=Node()
                    curNode.child.put(j,node)
                    curNode=node
                    node.total++
                }
            }
        }
        
        val answer=IntArray(queries.size){0}
        
        //정순, 역순, ????인것으로 구분
        for(i in queries.indices){
            val q=queries[i]
            if(q[0]=='?'){
                val r=q.reversed()
                answer[i]=match(nodes[r.length][1],r)
            }else{
                answer[i]=match(nodes[q.length][0],q)
            }
            
        }
        
        
        return answer
    }
    
    //정순이면 단어 그대로 넣고 역순이면 뒤집어서 넣기
    fun match(head:Node, str:String):Int{
        var idx=-1
        var cur=head
        while(true){
            if(str[idx+1]=='?') break
            else idx++
        }   
        
        //물음표로 시작하는 경우는 이과정 생략(idx==0인경우)=>이경우는 전체가 물음표
        if(idx!=-1){
            for(i in 0..idx){
                if(cur.child.keys.contains(str[i])){
                    cur=cur.child[str[i]] as Node
                }else{
                    return 0
                }
            }
        }
        
        
        return cur.total
    }
    
}

class Node(){
    val child=HashMap<Char,Node>()
    var total=0
}