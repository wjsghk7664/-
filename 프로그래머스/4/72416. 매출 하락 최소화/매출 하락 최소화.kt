class Solution {
    fun solution(sales: IntArray, links: Array<IntArray>): Int {
        var answer: Int = 0
        val nodes=ArrayList<Node>()
        nodes+=Node(0,0) //인데스 맞추기 위한 더미데이터
        for(i in 1..sales.size){
            nodes+=Node(i,sales[i-1])
        }
        for(i in links){
            nodes[i[0]].tails+=nodes[i[1]]
            nodes[i[1]].head=nodes[i[0]]
        }

        //숫자가 클수록 아래계층
        var height=0
        val stack = ArrayDeque<Node>()
        stack.addFirst(nodes[1])
        while(stack.isNotEmpty()){
            val curNode=stack.removeFirst()
            height=maxOf(curNode.height,height)
            for(i in curNode.tails){
                i.height=curNode.height+1
                stack.addFirst(i)
            }
        }
        //계층별로 삽입
        val hier=Array(height+1){ArrayList<Node>()}
        for(i in nodes){
            hier[i.height]+=i
        }

        
        //dp로 풀이 
        //dp[i][1] 은 i까지 하위 트리에 위치한 값들 총합중 i가 워크샵에 참여했을경우 최솟값
        //dp[i][0] 는 참여 안했을때 최솟값
        val dp=Array(nodes.size){IntArray(2){0}}
        
        for(i in hier.size-1 downTo 0){
            for(j in hier[i]){
                if(j.tails.isEmpty()){
                    dp[j.n][1]=j.sales //참석하는 경우
                    dp[j.n][0]=0 //참석안하는 경우
                }
                else{
                    //참석하는 경우: 먼저 자신의 salse를 더함
                    //팀원들이 참석하는 경우와 아닌경우중 더 적은 것들을 더해줌
                    dp[j.n][1]+=j.sales
                    for(k in j.tails){
                        dp[j.n][1]+=minOf(dp[k.n][0],dp[k.n][1])
                    }
                    
                    //참석 안하는 경우
                    //팀원들이 전부 참석안하는 경우가 최솟값인 경우=>참석했을때 가장 조금 늘어나는 팀원을 투입(dp[i][1]-dp[i][0])
                    //아니면 그냥 더해주면 됨
                    var sum=0
                    var sum0=0
                    var min=Int.MAX_VALUE
                    for(k in j.tails){
                        sum+=minOf(dp[k.n][0],dp[k.n][1])
                        sum0+=dp[k.n][0]
                        min=minOf(min,dp[k.n][1]-dp[k.n][0])
                    }
                    dp[j.n][0]=if(sum!=sum0) sum else sum+min
                    //println("${dp[j.n][0]}/${sum}/${sum0}")
                }
            }
        }
   
        return minOf(dp[nodes[1].n][0],dp[nodes[1].n][1])
    }
}

class Node(val n:Int, val sales:Int){
    var head:Node?=null
    val tails=ArrayList<Node>()
    var height=0
}