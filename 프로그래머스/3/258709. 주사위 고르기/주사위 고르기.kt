class Solution {
    fun solution(dice: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        
        val divs=div(dice.size)
        
        var maxA=0
        var maxAdices=divs[0]
        
        for(i in divs){
            var win=0
            val A=ArrayList<IntArray>()
            val B=ArrayList<IntArray>()
            
            i.forEachIndexed{idx,el -> if(el) A+=dice[idx] else B+=dice[idx]}
            
            val aResults=results(A)
            val bResults=results(B)
            
            for((ka,va) in aResults){
                for((kb,vb) in bResults){
                    if(ka>kb) win+=va*vb
                }
            }
            if(maxA<win){
                maxA=win
                maxAdices=i
            }
        }
        
        for((i,v) in maxAdices.withIndex()){
            if(v) answer+=i+1
        }
        
        return answer
    }
    
    fun results(dices:ArrayList<IntArray>):HashMap<Int,Int>{
        val result=HashMap<Int,Int>() //값, 경우의 수
        
        val q=ArrayDeque<Pair<Int,Int>>() //idx, sum
        q.addLast(Pair(0,0))
        
        while(q.isNotEmpty()){
            val (idx, sum) = q.removeFirst()
            
            if(idx==dices.size){
                result.put(sum, result.getOrDefault(sum,0)+1)
                continue
            }
            
            for(i in dices[idx]){
                q.addLast(Pair(idx+1,sum+i))
            }
        }
        return result
    }
    
    //주사위 나누기
    fun div(size:Int):ArrayList<BooleanArray>{
        val result=ArrayList<BooleanArray>()
        
        val a= Triple(BooleanArray(size){false},0,0) //sum,idx
        val q=ArrayDeque<Triple<BooleanArray,Int,Int>>()
        q.addLast(a)
        
        while(q.isNotEmpty()){
            val (cur,sum,idx) = q.removeFirst()
            
            if(sum==size/2){
                result+=cur
                continue
            }
            if(idx==size) continue
            
            val next=cur.copyOf().also{ it[idx]=true }
            q.addLast(Triple(next,sum+1,idx+1))
            q.addLast(Triple(cur,sum,idx+1))
        }
        return result
    }
}