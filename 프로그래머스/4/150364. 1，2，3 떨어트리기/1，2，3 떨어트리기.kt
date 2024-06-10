class Solution {
    fun solution(edges: Array<IntArray>, target: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var nodes=ArrayList<Node>()
        var visits=mutableMapOf<Int,ArrayList<Int>>() //키는 노드 번호, 어레이리스트는 방문 순서들
        var visitNum=ArrayList<Int>()
        var check=ArrayList<Int>() //0은 언더 1은 부합 2는 오버로
        var idx=0 //넣은 순서
        
        var result=mutableMapOf<Int,Int>() //키는 방문순서 값은 사전식배열된 숫자카드
        
        //리프노드들은 방문하면서 방문 순서와 방문 횟수를 저장
        //방문횟수로 만들어질 수 있는 값에 target이 들어가는지 모든 리프노드 검사
        //방문횟수가 x면: x <= target <=3x
        //전부 만족하는 순간 중지하고 방문 순서에 사전식으로 값을 넣음
        //안되는 경우:아직 방문횟수 범위보다 작은 노드가 있는데 방문횟수범위보다 큰 노드가 생기는 경우
        //즉, 언더, 부합, 오버 세 경우로 나누어서 언더와 부합만 있는동안 사이클을 돌리다가 언더와 오버가 같이 생기는 순간 -1 리턴
        
        
        
        for(i in target.indices){
            nodes+=Node(i+1)
            visitNum+=0
            check+=0
        }
        
        for(i in edges){
            nodes[i[0]-1].edge.add(nodes[i[1]-1])
        }
        
        for(i in nodes){
            if(i.edge.isEmpty()){
                i.leaf=true
                continue
            } 
            
            if(i.edge.size==1){
                i.edge[0].side=i.edge[0]
            }
            else{
                i.edge.sortBy{it.num}
                for(j in 0..i.edge.size-2){
                    i.edge[j].side=i.edge[j+1]
                }
                i.edge[i.edge.size-1].side=i.edge[0]
            }
            i.next=i.edge[0]
        }
        
        //leaf node만 방문map에 추가
        for(i in nodes){
            if(!i.leaf) continue
            visits.put(i.num,ArrayList<Int>())
        }
        
        //계속 leaf를 방문하면서 방문횟수와 순서를 쌓음
        while(true){
            var tmpNode=nodes[0]
            while(!tmpNode.leaf){
                var befNode=tmpNode
                tmpNode=tmpNode.next as Node
                befNode.next=befNode.next!!.side
            }
            
            visitNum[tmpNode.num-1]++
            visits[tmpNode.num]?.add(idx++)
            
            //모든 leaf체크
            for(i in check.indices){
                if(visitNum[i]*3<target[i]){
                    check[i]=0
                }else if(target[i]>=visitNum[i]){
                    check[i]=1
                }else{
                    check[i]=2
                }
            }
            
            val checks=checkLeaf(check)
            if(checks==1){
                break
            }else if(checks==2){
                return intArrayOf(-1)
            }
            
        }
        
        for((key, value) in visits){
            result.putAll(findList(visitNum[key-1],target[key-1],value))
        }
        
        for(i in 1..result.size){
            answer+=result[i-1]!!
        }
        
        return answer
    }
    
    //0: 진행, 1:전부 매치로 종료, 2:오버가 나서 종료
    fun checkLeaf(arr:ArrayList<Int>):Int{ 
        var under=false
        var match=false
        var over=false
        for(i in arr){
            if(i==0) under=true
            else if(i==1) match=true
            else over=true
        }
        
        
        if(!over){
            //오버는 안났지만 아직 모든 타겟이 범위에 들어오지 않은 경우
            if(under){
                return 0
            }
            //전부 매치인 경우
            else{
                return 1
            }
        }
        //오버가 난 경우
        else{
            return 2
        }
    }
    
    
    //target값을 완성시켜주는 리스트를 찾음
    //cnt는 방문 횟수
    fun findList(cnt:Int, target:Int, visits:ArrayList<Int>):MutableMap<Int,Int>{
        var arr=ArrayList<Int>()
        var result=mutableMapOf<Int,Int>()
        for(i in 1..cnt){
            arr+=3
        }
        while(sum(arr)!=target){
            for(i in arr.indices){
                if(arr[i]>1){
                    arr[i]--
                    break
                }
            }
        }
        for(i in 1..cnt){
            result.put(visits[i-1],arr[i-1])
        }
        return result
    }
    
    fun sum(arr:ArrayList<Int>):Int{
        var sum=0
        for(i in arr){
            sum+=i
        }
        return sum
    }
}


class Node(num:Int){
    val num:Int
    var leaf=false
    var edge=ArrayList<Node>()
    var side:Node?=null
    var next:Node?=null
    
    init{
        this.num=num
    }
}