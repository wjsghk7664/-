class Solution {
    fun solution(numbers: String): Int {
        var answer: Int = 0
        val weight=Array(10){IntArray(10)}

        //이동별 cost값 미리 저장
        for(i in 0..9){
            for(j in 0..9){
                if(i==j){
                    weight[i][j]=1
                    continue
                }
                var tmpi=i
                var tmpj=j
                if(tmpi==0) tmpi=11
                if(tmpj==0) tmpj=11

                var ix=(tmpi-1)%3
                var iy=(tmpi-1)/3
                var jx=(tmpj-1)%3
                var jy=(tmpj-1)/3

                var total=0
                while(ix!=jx||iy!=jy){
                    if(ix!=jx&&iy!=jy){
                        total+=3
                        ix+=if(ix>jx) -1 else 1
                        iy+=if(iy>jy) -1 else 1
                    }else if(ix!=jx){
                        total+=2
                        ix+=if(ix>jx) -1 else 1
                    }else if(iy!=jy){
                        total+=2
                        iy+=if(iy>jy) -1 else 1
                    }
                }
                weight[i][j]=total
            }
        }


        val queue=ArrayDeque<Node>()
        queue.addLast(Node(4,6,0,-1))

        val costs=IntArray(numbers.length){7*numbers.length+1}

        while(queue.isNotEmpty()){
            val curNode=queue.removeFirst()
            val idx=curNode.idx+1

            if(idx>numbers.length-1) continue

            val next=numbers[idx].toString().toInt()

            //왼쪽 이동
            if(next!=curNode.right){
                val tmpcost=curNode.cost+weight[curNode.left][next]
                var flag=true

                //같은 것을 찾아 코스트가 들어가있는것 보다 현재것이 작으면 해당 노드 제거
                //flag로 현재 노드보다 코스트가 작거나 같은 노드가 있는지 체크해 있으면 노드 추가 안함.
                if(queue.isNotEmpty()){
                    val removed=ArrayDeque<Node>()
                    for(i in queue){
                        if(curNode.equal(i)&&curNode.cost<i.cost){
                            removed.addLast(i)
                        }else if(curNode.equal(i)&&curNode.cost>=i.cost){
                            flag=false
                        }
                    }
                    for(i in removed) queue.remove(i)
                }
                if(flag){
                    queue+=Node(next,curNode.right,tmpcost,idx)
                    if(tmpcost<costs[idx]) costs[idx]=tmpcost
                }


            }

            //오른쪽 이동
            if(next!=curNode.left){
                val tmpcost=curNode.cost+weight[curNode.right][next]
                var flag=true

                //같은 것을 찾아 코스트가 들어가있는것 보다 현재것이 작으면 해당 노드 제거
                //flag로 현재 노드보다 코스트가 작거나 같은 노드가 있는지 체크해 있으면 노드 추가 안함.
                if(queue.isNotEmpty()){
                    val removed=ArrayDeque<Node>()
                    for(i in queue){
                        if(curNode.equal(i)&&curNode.cost<i.cost){
                            removed.addLast(i)
                        }else if(curNode.equal(i)&&curNode.cost>=i.cost){
                            flag=false
                        }
                    }
                    for (i in removed) queue.remove(i)
                }

                if(flag){
                    queue+=Node(curNode.left,next,tmpcost,idx)
                    if(tmpcost<costs[idx]) costs[idx]=tmpcost
                }
            }

        }

        return costs[numbers.length-1]
    }
}

class Node(var left:Int, var right:Int, var cost:Int, var idx:Int){

    fun equal(node:Node):Boolean{
        if(idx!=node.idx) return false

        val setA=setOf(left,right)
        val setB=setOf(node.left,node.right)
        if(setA==setB) return true
        else return false
    }
}