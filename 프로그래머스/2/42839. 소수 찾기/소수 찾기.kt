class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        
        val max = numbers.toCharArray().sortedDescending().joinToString("").toInt()
        
        val isPrime = BooleanArray(max+1){true}
        
        isPrime[1] = false
        isPrime[0] = false
        
        val gen = genList(numbers)
        
        for(i in 2..Math.sqrt(max.toDouble()).toInt()){
            for(j in gen){
                
                if(j%i==0&&j!=i) {
                    isPrime[j] = false
                }
            }
        }
        
        for(i in gen){
            if(isPrime[i]) answer++
        }
        
        return answer
    }
    
    fun genList(n:String):IntArray{
        val nums = n.split("").filter{it!=""}.map{it.toInt()}
        
        val list = HashSet<Int>()
        
        val q = ArrayDeque<Node>()
        
        for(i in nums){
            val new = Node(i,ArrayList(nums).apply{remove(i)})
            q.addLast(new)
            list+=i
        }
        
        while(q.isNotEmpty()){
            val cur = q.removeFirst()
            
            if(cur.numList.isEmpty()) continue
            
            
            for(i in cur.numList){
                val newnum = cur.num*10 + i
                val newNode = Node(newnum,ArrayList(cur.numList).apply{remove(i)})
                list+=newnum
                q.addLast(newNode)
            }
        }
        
        return list.toIntArray()
    }
}

data class Node(var num:Int, var numList:ArrayList<Int>)