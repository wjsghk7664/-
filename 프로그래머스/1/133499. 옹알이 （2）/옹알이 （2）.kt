class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        for(i:Int in 0..babbling.size-1){
            if(check(babbling[i])){
                answer++
            }
        }
        return answer
    }
    
    fun check(s:String):Boolean{
        if(dup(s)){
            return false
        }
        var tmp=s
        tmp=tmp.replace("aya","1")
        tmp=tmp.replace("ye","1")
        tmp=tmp.replace("woo","1")
        tmp=tmp.replace("ma","1")
        tmp=tmp.replace("1","")
        if(tmp==""){
            return true
        }
        else{
            return false
        }
    }
    
    fun dup(s:String):Boolean{
        var tmp=s
        tmp=tmp.replace("aya","1")
        tmp=tmp.replace("ye","2")
        tmp=tmp.replace("woo","3")
        tmp=tmp.replace("ma","4")
        var front='5'
        var back='6'
        for(i:Int in 0..tmp.length-1){
            front=back
            back=tmp[i]
            if(front==back){
                return true
            }
        }
        return false
    }
}