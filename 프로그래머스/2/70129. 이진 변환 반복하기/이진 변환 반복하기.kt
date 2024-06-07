class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var zeros=0
        var opNum=0
        var ss=s
        while(ss!="1"){
            var bef=ss.length
            ss=ss.replace("0","")
            var aft=ss.length
            zeros+=bef-aft
            opNum++
            ss=binary(aft)
        }
        answer+=opNum
        answer+=zeros
        return answer
    }
    fun binary(n:Int):String{
        var result=StringBuilder()
        var tmp=n
        while(tmp!=0){
            result.append(tmp%2)
            tmp/=2
        }
        return result.toString()
    }
}