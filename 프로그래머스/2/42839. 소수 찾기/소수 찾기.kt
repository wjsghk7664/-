class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        
        //nums에 모든 경우의 수 저장(1운 소수, 0은 합성수)
        val q=ArrayDeque<Node>()
        val nums=HashMap<Int,Int>()
        val inits=Node()
        inits.setinit(numbers)
        q.addLast(inits)
        while(q.isNotEmpty()){
            val cur=q.removeFirst()
            
            if(cur.n>1) nums.put(cur.n,1)
            
            for(i in cur.bef){
                q.addLast(cur.choose(i))
            }
        }
        
        val max=nums.keys.maxOrNull() as Int
        
        for(i in 2..Math.sqrt(max.toDouble()).toInt()){
            for((k,v) in nums){
                if(k%i==0&&k!=i){
                    nums.put(k,0)
                }
            }
        }
        
        
        for((k,v) in nums){
            answer+=v
        }
        
        return answer
    }
}

class Node(){
    var n=0
    val bef=ArrayList<Int>()
    
    fun setinit(numbers:String){
        for(i in numbers){
            bef+=i.toString().toInt()
        }
    }
    fun choose(num:Int):Node{
        val node=Node()
        val idx=this.bef.indexOf(num)
        for((i,v) in this.bef.withIndex()){
            if(i==idx) continue
            node.bef+=v
        }
        node.n=this.n*10+num
        return node
    }
}