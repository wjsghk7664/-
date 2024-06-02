class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        for(i:Int in 0..privacies.size-1){
            var exp=0
            val spl=privacies[i].split(" ")
            for(j:Int in 0..terms.size-1){
                if(terms[j][0]+""==spl[1]){
                    exp=terms[j].split(" ")[1].toInt()
                }
            }
            
            val date=date(spl[0],exp)
            if(date<=today){
                answer+=i+1
            }
        }
        return answer
    }
    
    fun date(s:String, exp:Int):String{
        val tmp=s.split(".")
        var dates=mutableListOf(tmp[0].toInt(),tmp[1].toInt(),tmp[2].toInt())
        dates[1]+=exp
        if(dates[1]%12==2&&dates[2]>28){
            dates[1]++
            dates[2]-=28
        }
        if(dates[1]>12){
            dates[0]+=dates[1]/12
            dates[1]%=12
        }
        if(dates[1]==0){
            dates[1]=12
            dates[0]--
        }
        val year=dates[0].toString()
        val month=if(dates[1]<10) "0${dates[1]}" else dates[1].toString()
        val day=if(dates[2]<10) "0${dates[2]}" else dates[2].toString()
        return year+"."+month+"."+day
    }
}