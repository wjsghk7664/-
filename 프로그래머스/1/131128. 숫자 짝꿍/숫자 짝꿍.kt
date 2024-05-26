class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        var tmp=StringBuilder()
        
        var xlist=MutableList<Int>(10,{i->0})
        var ylist=MutableList<Int>(10,{i->0})
        
        for(i:Int in 0..X.length-1){
            xlist[X[i].toInt()-48]+=1
        }
        for(i:Int in 0..Y.length-1){
            ylist[Y[i].toInt()-48]+=1
        }
        
        for(i:Int in 9 downTo 0){
            var min=min(xlist[i],ylist[i])
            if(min>0){
                var itmp=i.toString()
                for(j:Int in 1..min){
                    tmp.append(i)
                }
            }
        }
        
        answer=tmp.toString()
        
        if(answer==""){
            answer+="-1"
        }
        else if(answer.replace("0","")==""){
            answer=answer.replace("0","")+"0"
        }
        return answer
    }
    
    fun min(n:Int, m:Int):Int{
        if(n>m){
            return m
        }
        else{
            return n
        }
    }
}