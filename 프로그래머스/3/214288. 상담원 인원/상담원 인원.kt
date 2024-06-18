class Solution {
    fun solution(k: Int, n: Int, reqs: Array<IntArray>): Int {
        var answer: Int = 0
        var mentor=IntArray(k+1){1}
        while(mentor.sum()<=n){
            var min=Int.MAX_VALUE
            var minIdx=0
            for(i in 1..k){
                var tmp=mentor.copyOf()
                tmp[i]++
                var tmptime=waitTime(tmp,reqs,k)
                if(min>tmptime){
                    min=tmptime
                    minIdx=i
                }
            }
            mentor[minIdx]++
        }
        return waitTime(mentor,reqs,k)
    }
    
    fun waitTime(men:IntArray, reqs:Array<IntArray>, k:Int ):Int{
        var time=0
        for(i in 1..k){
            val mens=men[i]
            val arr=IntArray(mens){0}
            for(j in reqs){
                if(j[2]==i){
                    var min=arr.minOrNull() as Int
                    val minIdx=arr.indexOf(min)
                    min=maxOf(min,j[0])
                    time+=maxOf(0,min-j[0])
                    arr[minIdx]=min+j[1]
                }
            }
        }
        println(men.contentToString())
        println(time)
        return time
    }
}