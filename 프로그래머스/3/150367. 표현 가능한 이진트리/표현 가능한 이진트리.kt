class Solution {
    fun solution(numbers: LongArray): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in numbers){
            answer+=if(check(i)) 1 else 0
        }
        return answer
    }
    
    fun check(n:Long):Boolean{
        val str=java.lang.Long.toBinaryString(n).reversed()
        var num=n
        //println("스트링"+str)
        
        //1일때는 return true
        if(n==1L) return true
        
        val queue=ArrayDeque<Pair<Int,Int>>() //인덱스, 높이
        
        val height=height(num).toInt()
        //println("${n}: 높이:${height}")
        var mid=1
        repeat(height-1){mid*=2}
        
        if(mid>str.length) return false
        
        queue.addLast(Pair(mid,height))
        while(queue.isNotEmpty()){
            val cur=queue.removeFirst()
            
            if(cur.second==1) continue
            
            var pow=1
            repeat(cur.second-2){pow*=2}
            
            val front=cur.first+pow
            val back=cur.first-pow
            
            val curValue=if(cur.first>str.length) '0' else str[cur.first-1]
            val frontValue=if(front>str.length) '0' else str[front-1]
            val backValue=if(back>str.length) '0' else str[back-1]
            //println(curValue)
            if(curValue=='0'){
                if(frontValue=='1'||backValue=='1'){
                    return false
                }
            }
            queue.addLast(Pair(front,cur.second-1))
            queue.addLast(Pair(back,cur.second-1))
            
        }
        
        
        return true
    }
    
    fun height(num:Long):Long{
        var tmp=num
        var idx=0L
        while(tmp!=1L){
            tmp/=2L
            ++idx
        }
        ++idx
        var idxx=0L
        while(idx!=1L){
            idx/=2L
            ++idxx
        }
        return idxx+1
    }
}