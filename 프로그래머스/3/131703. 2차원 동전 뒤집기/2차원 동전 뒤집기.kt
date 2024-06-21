class Solution {
    fun solution(b: Array<IntArray>, t: Array<IntArray>): Int {
        var answer: Int = 0
        var min=21
        
        val rcCheck=IntArray(b.size+b[0].size){0}
        if(check(b,t)) return 0
        
        while(addOne(rcCheck)){
            var cnt=0
            //i 행 뒤집기
            val k=copy(b)
            for(i in 0..b.size-1){
                if(rcCheck[i]==1){
                    rowOp(k,i)
                    ++cnt
                }
            }
            
            //i 열 뒤집기
            for(i in 0..b[0].size-1){
                if(rcCheck[i+b.size]==1){
                    colOp(k,i)
                    ++cnt
                }
            }
            
            if(check(k,t)){
                min=minOf(min,cnt)
            }
        }
        if(min==21) min=-1
        
        return min
    }
    
    fun copy(b:Array<IntArray>):Array<IntArray>{
        val new=Array<IntArray>(b.size){IntArray(b[0].size){0}}
        
        for(i in b.indices){
            for(j in b[0].indices){
                new[i][j]=b[i][j]
            }
        }
        return new
    }
    
    //끝나면 false
    fun addOne(arr:IntArray):Boolean{
        var idx=0
        while(true){
            if(idx==arr.size) return false
            if(arr[idx]==0){
                arr[idx]=1
                break
            }else{
                arr[idx]=0
                ++idx
            }
        }
        return true
    }
    
    fun check(arr:Array<IntArray>, t:Array<IntArray>):Boolean{
        for(i in arr.indices){
            for(j in arr[0].indices){
                if(arr[i][j]!=t[i][j]) return false
            }
        }
        return true
    }
    
    fun rowOp(arr:Array<IntArray>, r:Int){
        for(i in 0..arr[r].size-1){
            if(arr[r][i]==0) arr[r][i]=1 else arr[r][i]=0
        }
    }
    
    fun colOp(arr:Array<IntArray>, c:Int){
        for(i in 0..arr.size-1){
            if(arr[i][c]==0) arr[i][c]=1 else arr[i][c]=0
        }
    }
}