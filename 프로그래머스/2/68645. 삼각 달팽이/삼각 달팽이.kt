class Solution {
    
    lateinit var arr:Array<IntArray>
    
    fun solution(n: Int): IntArray {
        
        arr=Array(n){IntArray(n)}
        
        var top=0
        var bot=n-1
        val left=IntArray(n)
        var right=IntArray(n){it}
        
        val len=(n*(n+1))/2
        
        var answer: IntArray = IntArray(len)
        
        find(top,bot,left,right,1)
        
        var idx=0
        for(i in 0..n-1){
            for(j in 0..n-1){
                if(arr[i][j]==0) break
                answer[idx++]=arr[i][j]
            }
        }
        
        return answer
    }
    
    fun find(top:Int, bot:Int,left:IntArray,right:IntArray,idxinit:Int){
        if(top>bot) return 
        var idx=idxinit
        for(i in top..bot){
            arr[i][left[i]++]=idx++
        }
        for(i in left[bot]..right[bot]){
            arr[bot][i]=idx++
        }
        for(i in bot-1 downTo top+1){
            arr[i][right[i]--]=idx++
        }
        find(top+2,bot-1,left,right,idx)
    }
}