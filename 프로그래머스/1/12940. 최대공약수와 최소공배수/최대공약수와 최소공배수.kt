class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf()
        var gcd=gcd(n,m)
        answer+=gcd
        answer+=(n*m)/gcd
        return answer
    }
    
    fun gcd(n:Int, m:Int): Int {
        var (max,min)=if(n>m){
            arrayOf(n,m)
        }
        else{
            arrayOf(m,n)
        }
        var tmp=max%min
        if(tmp==0){
            return min
        }
        else{
            return gcd(min, tmp)
        }
    }
}