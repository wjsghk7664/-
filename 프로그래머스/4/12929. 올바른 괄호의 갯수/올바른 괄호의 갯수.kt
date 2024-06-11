class Solution {
    fun solution(n: Int): Int {
        return check(n,0,0)
    }
    
    fun check(n:Int, left:Int, right:Int):Int{
        val result=0
        if(left<right) return 0
        if(left>n||right>n) return 0
        if(left==right&&left==n){
            return 1
        }
        return result+check(n,left+1,right)+check(n,left,right+1)
    }
}