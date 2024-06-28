class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val name=ArrayList<String>()
        val inlist=ArrayList<String>()
        val total=ArrayList<Int>()
        
        //처음 집어넣을때 name,inlist뿐만아니라 total에도 0넣어주기
        
        for(j in records){
            val i=j.split(" ")
            if(!name.contains(i[1])){
                name+=i[1]
                inlist+=i[0]
                total+=0
            }else{
                val idx=name.indexOf(i[1])
                if(i[2]=="IN"){
                    inlist[idx]=i[0]
                }else{
                    val inTime=inlist[idx].split(":").map{it.toInt()}
                    val outTime=i[0].split(":").map{it.toInt()}
                    total[idx]+=outTime[1]-inTime[1]+60*(outTime[0]-inTime[0])
                    inlist[idx]="-1"
                }
            }
        }
        for(i in inlist.indices){
            if(inlist[i]!="-1"){
                val inTime=inlist[i].split(":").map{it.toInt()}
                val outTime=intArrayOf(23,59)
                total[i]+=outTime[1]-inTime[1]+60*(outTime[0]-inTime[0])
            }
        }
        val map=mutableMapOf<String,Int>()
        for(i in name.indices){
            map.put(name[i],total[i])
        }
        val order=map.keys.sorted()
        for(i in order){
            val time=map[i] as Int
            if(time<=fees[0]) answer+=fees[1]
            else answer+=fees[1]+((time-fees[0])/fees[2] +if((time-fees[0])%fees[2]!=0) 1 else 0)*fees[3]
        }
        return answer
    }
}