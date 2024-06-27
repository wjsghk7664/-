class Solution {
    fun solution(land: Array<IntArray>, height: Int): Int {
        var answer = 0
        val n=land.size
        //그룹화
        //그룹별 사다리 생성
        //MST구하기-prim
        
        //그룹화
        //visited는 방문을 체크하면서도 그룹화된 영역을 체크하는 용도로 쓰임
        val visited=Array(n){IntArray(n){0}}
        var gNum=1
        for(i in 0..n-1){
            for(j in 0..n-1){
                if(visited[i][j]==0){
                    group(land,visited,i,j,height,n,gNum++)
                }
            }
        }
        
        //사다리 찾기
        //visited를 순회하며 경계부분에 해당하면 사다리를 구함
        
        val edge=mutableMapOf<HashSet<Int>,Int>() //출발지와 도착지가 담긴 set, 사다리 비용
        
        val di=intArrayOf(0,0,1,-1)
        val dj=intArrayOf(1,-1,0,0)
        for(i in 0..n-1){
            for(j in 0..n-1){
                for(k in 0..3){
                    val x=i+di[k]
                    val y=j+dj[k]
                    if(x in 0..n-1&&y in 0..n-1&&visited[i][j]!=visited[x][y]){
                        val idx=hashSetOf(visited[i][j],visited[x][y])
                        val tmp=edge?.get(idx)?:Int.MAX_VALUE
                        edge.put(idx,minOf(tmp,Math.abs(land[i][j]-land[x][y])))
                    }
                }
            }
        }
        
        
        //MST구하기
        //prim알고리즘으로 구함
        //도착지와 가중치값이 들어있는 배열 생성(인덱스는 1부터 gNum-1까지)
        val nodes=ArrayList<Triple<Int,Int,Int>>()
        for((k,v) in edge){
            val tmp=ArrayList<Int>()
            for(i in k){
                tmp+=i
            }
            nodes+=Triple(tmp[0],tmp[1],v)
            nodes+=Triple(tmp[1],tmp[0],v)
        }
        
        nodes.sortBy{it.third}
        
        var roots=IntArray(gNum){it} //인덱스가 자기 부모노드. 초기는 자기 자신이 들어가있음
        var rank=IntArray(gNum){0}
        for(i in nodes){
            if(find(i.first,roots)==find(i.second,roots)) continue
            answer+=i.third
            union(i.first,i.second,roots,rank)
        }
        
        return answer
    }
    
    fun find(x:Int, roots:IntArray):Int{
        var root=x
        while(true){
            root=roots[root]
            if(root==roots[root]) break
        }
        return root
    }
    
    fun union(x:Int, y:Int, roots:IntArray, rank:IntArray){
        val xRoot=find(x,roots)
        val yRoot=find(y,roots)
        
        if(xRoot==yRoot) return 
        
        if(rank[xRoot]<rank[yRoot]) roots[xRoot]=yRoot
        else if(rank[xRoot]>rank[yRoot]) roots[yRoot]=xRoot
        else{
            roots[yRoot]=xRoot
            rank[xRoot]++
        }
        
        
    }
    

    fun group(land:Array<IntArray>,visited:Array<IntArray>,si:Int,sj:Int,height:Int,n:Int,gNum:Int){
        val di=intArrayOf(0,0,1,-1)
        val dj=intArrayOf(1,-1,0,0)
        
        val stack=ArrayDeque<Pair<Int,Int>>()
        stack.addFirst(Pair(si,sj))
        visited[si][sj]=gNum
        
        while(stack.isNotEmpty()){
            val (ci,cj)=stack.removeFirst()
            
            for(i in 0..3){
                val x=ci+di[i]
                val y=cj+dj[i]
                if(x in 0..n-1&&y in 0..n-1&&visited[x][y]==0&&Math.abs(land[x][y]-land[ci][cj])<=height){
                    visited[x][y]=gNum
                    stack.addFirst(Pair(x,y))
                }
            }
        }
    }
}




