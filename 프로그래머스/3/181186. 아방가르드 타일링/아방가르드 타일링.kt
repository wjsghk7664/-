class Solution {
    fun solution(n: Int): Int {
        //fn=afn-1 + bfn-2 +cfn-3 +...꼴의 점화식
        //여기서 계수는 fn-t가 n개짜리를 만들려면 unique한 t개짜리를 붙여줘야 하므로 unique한 t개의 개수만큼 곱해준다.
        //1-1, 2-2, 3-5, 4-2, 5-2, 6-4
        //4부터 6까지는 반복
        //즉 f(n)=f(n-1)+2f(n-2)+5f(n-3)+2f(n-4)+2f(n-5)+4f(n-6)+...
        // f(n)-f(n-3)을 해주면 f(n)=f(n-1)+2f(n-2)+6f(n-3)+f(n-4)-f(n-5)
        //4~6은 직접 구하고 그 뒤는 점화식으로 품
        
        if(n==1) return 1
        if(n==2) return 3
        if(n==3) return 10
        if(n==4) return 23
        if(n==5) return 62
        if(n==6) return 170
        
        
        val dp=LongArray(n+1)
        dp[1]=1L
        dp[2]=3L
        dp[3]=10L
        dp[4]=23L
        dp[5]=62L
        dp[6]=170L
        
        for(i in 7..n){
            dp[i]=(dp[i-1]%1000000007L+(2*dp[i-2])%1000000007L+(6*dp[i-3])%1000000007L+dp[i-4]%1000000007L-dp[i-6]%1000000007L+1000000007L)%1000000007L
        }
        
        
        return dp[n].toInt()
    }
    
}