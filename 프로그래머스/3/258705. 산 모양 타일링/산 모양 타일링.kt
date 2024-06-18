class Solution {
    fun solution(n: Int, tops: IntArray): Int {
        
        //우하단 칠하는 경우에(사각형으로 채우는 경우) 따라 나누어 구함
        //tri[i][0]가 안칠한 경우, tri[i][1]이 칠한 경우일시 
        
        val tri=Array(n){IntArray(2){0}}
        tri[0][1]=1 
        tri[0][0]=if(tops[0]==1) 3 else 2
        for(i in 1..n-1){
            if(tops[i]==1){
                tri[i][0]=(3*tri[i-1][0]+2*tri[i-1][1])%10007
            }else{
                tri[i][0]=(2*tri[i-1][0]+tri[i-1][1])%10007
            }
            
            tri[i][1]=(tri[i-1][0]+tri[i-1][1])%10007
        }
      
        
        return (tri[n-1][0]+tri[n-1][1])%10007
    }
}