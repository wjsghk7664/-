class Solution {
    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        var answer: Int = 0
        
        val size=table.size
        
        
        val gamePiece=BFS(0,game_board)
        val tablePiece=BFS(1,table)
        
        val gamePieceWithRotationIdx=Array(gamePiece.size){HashSet<List<Int>>()}
        val tablePieceIdx=tablePiece.map{indexing(it,size)}
        
        for(i in 0..gamePiece.size-1){
            for(j in 0..3){
                gamePieceWithRotationIdx[i]+=indexing(gamePiece[i],size)
                rotation(gamePiece[i])
            }
        }
        
        
        
        
        val isUsed=BooleanArray(gamePieceWithRotationIdx.size){false}
        
        for(i in tablePieceIdx){
            for((idx,j) in gamePieceWithRotationIdx.withIndex()){
                if(isUsed[idx]) continue
                var flag=false
                for(k in j){
                    if(i==k&&!isUsed[idx]){
                        flag=true
                        answer+=i.size
                        isUsed[idx]=true
                        break
                    }
                }
                if(flag) break
            
            }
        }
        
        
        return answer
    }
}

fun indexing(piece:Piece, size:Int):List<Int>{
    val result=HashSet<Int>()
    
    val visited=HashSet<Block>()
    
    val q=ArrayDeque<Pair<Int,Block>>()
    q.addLast(Pair(0,piece.blocks[0]))
    visited+=piece.blocks[0]
    
    while(q.isNotEmpty()){
        val (idx,b)=q.removeFirst()
        result+=idx
        
        for(i in 0..3){
            b.adj[i]?.let{
                if(!visited.contains(it)){
                    when(i){
                        0 -> q.addLast(Pair(idx-size,it))
                        1 -> q.addLast(Pair(idx+1,it))
                        2 -> q.addLast(Pair(idx+size,it))
                        else -> q.addLast(Pair(idx-1,it))
                    }
                    visited+=it
                }
            }
        }
    }
    return result.sorted().let{it.map{b -> b-it[0]}}
}

fun blockRotation(block:Block){
    block.adj.also{
        val tmp=it[0]
        it[0]=it[1]
        it[1]=it[2]
        it[2]=it[3]
        it[3]=tmp
    }
}

fun rotation(piece:Piece){
    for(i in piece.blocks){
        blockRotation(i)
    }
}

fun BFS(type:Int, arr:Array<IntArray>):ArrayList<Piece>{
    val size=arr.size
    val visited=BooleanArray(size*size){false}
    val result=ArrayList<Piece>()
    
    for(i in arr.indices){
        for(j in arr.indices){
            if(arr[i][j]!=type){
                visited[i*size+j]=true
            }
        }
    }
    
    val q=ArrayDeque<Triple<Int,Block,Piece>>()
    
    var initIdx=0
    
    for(i in visited.indices){
        if(!visited[i]){
            visited[i]=true
            initIdx=i
            break
        }
    }
    
    val piece=Piece()
    val block=Block()
    piece.blocks+=block
    result+=piece
    
    q.addLast(Triple(initIdx,block,piece))
    
    val dx=listOf(0,0,1,-1)
    val dy=listOf(1,-1,0,0)
    
    while(q.isNotEmpty()){
        val (idx,b,p)=q.removeFirst()
        
        val x=idx/size
        val y=idx%size
        
        for(i in 0..3){
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx !in 0..size-1||ny !in 0..size-1) continue
            val nextIdx=nx*size+ny
            if(!visited[nextIdx]){
                visited[nextIdx]=true
                val newB=Block()
                p.blocks+=newB
                when(i){
                    0 ->{
                        b.adj[2]=newB
                        newB.adj[0]=b
                    }
                    1 ->{
                        b.adj[0]=newB
                        newB.adj[2]=b
                    }
                    2->{
                        b.adj[1]=newB
                        newB.adj[3]=b
                    }
                    else->{
                        b.adj[3]=newB
                        newB.adj[1]=b
                    }
                }
                q.addLast(Triple(nextIdx,newB,p))
            }
        }
        
        if(q.isEmpty()){
            for(i in visited.indices){
                if(!visited[i]){
                    visited[i]=true
                    val piece=Piece()
                    val block=Block()
                    piece.blocks+=block
                    result+=piece
                    q.addLast(Triple(i,block,piece))
                    break
                }
            }
        } 
    }
    return result
}


class Block( ){
    val adj:MutableList<Block?> =mutableListOf(null,null,null,null)//위 오른 아래 왼
}

class Piece(){
    val blocks=ArrayList<Block>()
}