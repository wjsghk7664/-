class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 1
        for(i in arr){
            answer=lcm(answer,i)
        }
        
        
        return answer
    }
    
    fun gcd(a:Int, b:Int):Int{
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }
    
    fun lcm(a:Int, b:Int):Int{
        var gcd=gcd(a,b)
        return (a*b)/gcd
    }
    

}