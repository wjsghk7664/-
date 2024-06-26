class Solution {
    fun solution(a: Array<IntArray>): Int {
        var answer: Int = -1
        
        var coln=IntArray(a[0].size){0}
        val row=a.size //행 개수, 세로길이
        val col=a[0].size //열 개수, 가로길이
        
        for(i in a[0].indices){
            var sum=0
            for(j in a.indices){
                sum+=a[j][i]
            }
            coln[i]=sum
        }
        
        println(coln.contentToString())
        
        val mod=10000019
        
        val c=Array(row+1){IntArray(row+1)} //파스칼 법칙 이용해 rowCrow까지 연산해서 저장해둠, c[n][r]=nCr
        for(i in 1..row){
            for(j in 0..i){
                if(i==j) c[i][j]=1
                else if(j==0) c[i][j]=1
                else c[i][j]=(c[i-1][j-1]+c[i-1][j])%mod
            }
        }
        
        val dp=Array(col){IntArray(row+1){0}} //dp[선택된 열][까지의 짝수행 개수]
        
        dp[0][row-coln[0]]=c[row][row-coln[0]] //열의 원소는 row개. 그중 짝수행인 0의 자리를 고르는 경우의수
        
        //선택된 열i, 짝수행수 j
        //dp[i][j]==0이면 스킵
        //다음 선택에 대하여 짝수행중 k개를 선택한다고 하자
        //선택가능한 k범위는 
        //최소:maxOf(0,coln[i+1]-(row-j)) =>홀수행을 다 선택하고도 1이 남는 경우 고려
        //최대:minOf(j,coln[i+1]) =>1의 수가 충분하면 j개까지 선택되고 아니면 최대 1의 개수만큼 선택됨
        //그렇게 짝수행에서 k개 선택시 나오는 짝수행 수 = (홀수행에서 1선택한 개수) + (짝수행에서 1 선택 안한 개수)=>coln[i+1]-k +(j-k)
        //최종 경우의 수:짝수행에서 1선택 * 홀수행에서 1선택 *이전열까지의 dp경우의 수
        
        
        for(i in 0..col-2){
            for(j in 0..row){
                if(dp[i][j]==0) continue
                val oddr=row-j
                val min=maxOf(0,coln[i+1]-oddr)
                val max=minOf(j,coln[i+1])
                for(k in min..max){
                    val next=coln[i+1]-k +(j-k)
                    
                    if(next>row || j<k) continue
                    
                    val case=(c[j][k]*c[row-j][coln[i+1]-k])%mod
                    dp[i+1][next]+=(dp[i][j]*case)%mod
                }
                
            }
        }
 
        for(i in dp){
            println(i.contentToString())
        }
        
        return dp[col-1][row]
    }
}