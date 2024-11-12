class Solution {
    fun solution(numbers: IntArray): String {
        if(numbers.sum()==0) return "0"
        
        val conv = ArrayList<Pair<Int,Int>>()
        for(i in numbers){
            if(i==0){
                conv+=Pair(0,0)
            }
            else if(i<10){
                conv+=Pair(i*1111, i)
            }else if(i<100){
                conv+=Pair(i*100+i,i)
            }else if(i<1000){
                conv+=Pair(i*10+i/100,i)
            }else{
                conv+=Pair(1000,1000)
            }
        }
        conv.sortWith{a,b -> b.first - a.first}
        var answer =""
        for(i in conv){
            answer+=i.second.toString()
        }
        return answer
    }
}