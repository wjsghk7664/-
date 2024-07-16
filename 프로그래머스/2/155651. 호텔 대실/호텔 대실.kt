class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        
        
        book_time.sortBy{it[0]}
        val rooms=ArrayList<String>()
        for(i in book_time){
            val timeUpdate=i[0]
            val removed=ArrayList<Int>()
            for((j,v) in rooms.withIndex()){
                if(timeUpdate>=v){
                    removed+=j
                }
            }
            removed.reverse()
            for(j in removed){
                rooms.removeAt(j)
            }
            rooms+=add10(i[1])
            
            answer=maxOf(answer,rooms.size)
        }
        return answer
    }
    fun add10(str:String):String{
        val list=str.split(":").map{it.toInt()} as MutableList<Int>
        list[1]+=10
        if(list[1]>59){
            list[1]-=60
            list[0]+=1
        }
        val first="%02d".format(list[0])
        val second="%02d".format(list[1])
        return first+":"+second
    }
}