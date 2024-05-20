class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""
        var c1=cards1
        var c2=cards2
        var g=goal
        while(!g.isEmpty()){
            if(c1.size!=0&&c1[0]==g[0]){
                c1=del(c1)
                g=del(g)
            }
            else if(c2.size!=0&&c2[0]==g[0]){
                c2=del(c2)
                g=del(g)
            }
            else{
                break
            }
        }
        if(g.size==0){
            answer="Yes"
        }
        else{
            answer="No"
        }
        return answer
    }
    
    fun del(s:Array<String>):Array<String>{
        var tmp=emptyArray<String>()
        if(s.size<=1){
            return tmp
        }
        for(i:Int in 1..s.size-1){
            tmp+=s[i]
        }
        return tmp
    }
}