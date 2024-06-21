class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        var answer: String = ""
        
        
        if((k-Math.abs(x-r)-Math.abs(y-c)%2!=0||k<Math.abs(x-r)+Math.abs(y-c)) return "impossible"
        
        
        val dulr=intArrayOf(0,0,0,0)
        if(x<r) dulr[0]=r-x else dulr[1]=x-r
        if(y<c) dulr[3]=c-y else dulr[2]=y-c
        
        var cost=k
        var curx=x
        var cury=y
        
        //최소움직임만큼 미리 제거. 최소움직임만큼 움직일때는 코스트 제거x
        cost-=dulr[0]+dulr[1]+dulr[2]+dulr[3]
        
        //일단 도착지만큼 d를 움직임
        curx+=dulr[0]
        repeat(dulr[0]){
            answer+="d"
        }
        
        //추가로 남는 코스트에서 최소 lr을 움직일 코스트와 u 움직일 코스트를 제외
        //그 후 남은 코스트에서 절반과 바닥에 닿는 n-curx중 더 작은 값만큼 간다.
    
        var distD=minOf(cost/2,n-curx)
        
        curx+=distD
        cost-=distD
        repeat(distD){
            answer+="d"
        }
        
        cost-=distD //u움직임 미리 빼둠
        
        
        //일단 도착지 위치까지 만큼 l을 움직임
        cury-=dulr[2]
        repeat(dulr[2]){
            answer+="l"
        }
        
        
        //우선 우측에 가야할 코스트를 제외해둠
        //이후 남은 코스트에서 절반과 벽에 닿는 cury-1중 더 작은값만큼 간다.
        var distL=minOf(cost/2,cury-1)
        cury-=distL
        cost-=distL
        repeat(distL){
            answer+="l"
        }
        
        cost-=distL //r 가야하는 부분 미리 빼줌
        
        //최종적으로 남은 코스트만큼 rl을 반복
        repeat(cost/2){
            answer+="rl"
            
        }
        
        //우측 추가
        
        while(cury!=c){
            answer+="r"
            cury++
        }
        
        //상단 추가
        
        while(curx!=r){
            answer+="u"
            curx--
        }
       
        return answer
    }
    
    
}