class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        val result=check(arr,0,0,arr.size)
        answer+=result.second
        answer+=result.first
        return answer
    }
    fun check(arr:Array<IntArray>,sx:Int,sy:Int,l:Int):Pair<Int,Int>{
        var zero=0
        var one=0
        var flag=true
        var check=arr[sx][sy]
        for(i in sx..sx+l-1){
            for(j in sy..sy+l-1){
                if(check!=arr[i][j]){
                    flag=false
                    break
                }
            }
        }
        if(flag){
            if(check==0) one++ else zero++
            return Pair(zero,one)
        }
        else{
            val (lu0,lu1)=check(arr,sx+l/2,sy+l/2,l/2)
            val (ru0,ru1)=check(arr,sx,sy+l/2,l/2)
            val (ld0,ld1)=check(arr,sx+l/2,sy,l/2)
            val (rd0,rd1)=check(arr,sx,sy,l/2)
            zero=lu0+ru0+ld0+rd0
            one=lu1+ru1+ld1+rd1
            return Pair(zero,one)
        }
    }
}