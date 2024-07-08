class Solution {
    val MOD=1000000007
    fun solution(grid: Array<IntArray>, d: IntArray, k: Int): Int {
        var answer: Int = 0
        
        //시작점 끝점 경우의수:좌표는 배열로 나타냄
        val route=HashMap<String,HashSet<String>>() //처음좌표,현재좌표
        val cost=HashMap<String,Int>() //처음좌표+현재좌표, cost 
        
        val leni=grid.size
        val lenj=grid[0].size
        //루트찾기
        val di=intArrayOf(1,-1,0,0)
        val dj=intArrayOf(0,0,1,-1)
        
        //dp를 이용 [idx][시작좌표][현재좌표]=경우의수
        val dp=Array(d.size+1){Array(leni*lenj){IntArray(leni*lenj){0}}}
        
        //아직 안움직인 경우의수:1
        for(i in 0..leni*lenj-1){
            dp[0][i][i]=1
        }
        
        for(i in 1..d.size){
            for(j in 0..leni*lenj-1){
                val x=j/lenj
                val y=j%lenj
                for(k in 0..3){
                    val dx=x+di[k]
                    val dy=y+dj[k]
                    if(dx in 0..leni-1&&dy in 0..lenj-1&&grid[dx][dy]-grid[x][y]==d[i-1]){
                        for(l in 0..leni*lenj-1){
                            dp[i][l][dx*lenj+dy]+=dp[i-1][l][j]%MOD
                            dp[i][l][dx*lenj+dy]%=MOD
                        }
                    }
                    
                }
            }
        }
        
        //시작,끝, 경우의수가 담긴 행렬
        //행렬곱을  n번하면 i,j원소가 i에서 j까지 n번에 걸쳐 가는 경우의수
        //즉 k번 곱하면 나온 원소들의 합이 정답
        //k번 곱하기 보다는 k를 2진수로 변환해서 2의 제곱수들의 합으로 k를 만들음
        var mat=dp[d.size]
        var result=Array(mat.size){IntArray(mat.size)}
        for(i in 0..mat.size-1){
            result[i][i]=1
        }
        
        val str=k.toString(2).reversed()
        
        
        
        for(i in 0..str.length-1){
            if(str[i]=='1'){
                result=matmult(result,mat)
            }
            mat=matmult(mat,mat)
        }
        
        for(i in 0..mat.size-1){
            for(j in 0..mat.size-1){
                answer+=result[i][j]
                answer%=MOD
            }
        }

        
        
        return answer
    }
    
    fun matmult(m1:Array<IntArray>, m2:Array<IntArray>):Array<IntArray>{
        val n=m1.size
        val result=Array(n){IntArray(n)}
        for(i in 0..n-1){
            for(j in 0..n-1){
                for(k in 0..n-1){
                    result[i][j]+=((m1[i][k].toLong()*m2[k][j].toLong())%MOD.toLong()).toInt()
                    result[i][j]%=MOD
                }
            }
        }
        return result
    }
    
    
}


