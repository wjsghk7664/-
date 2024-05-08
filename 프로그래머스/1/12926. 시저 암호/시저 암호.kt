class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for(i:Int in 0..s.length-1){
            if(s[i]==' '){
                answer+=' '
            }
            else{
                var tmpbf=s[i].toInt()
                var tmp=tmpbf+n
                if((tmpbf<=122&&tmp>122)||(tmpbf<=90&&tmp>90)){
                    tmp-=26
                }
                answer+=tmp.toChar()
            }
            
        }
        return answer
    }
}