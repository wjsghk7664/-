class Solution {
    fun solution(name: String): Int {
        var answer = 0
        answer+=Alpha(name)
        answer+=Move(name)
        return answer
    }
    
    fun Alpha(name:String):Int{
        var total = 0
        for(i in name){
            total+=minOf(i.toInt() - 'A'.toInt(), 'Z'.toInt() - i.toInt() + 1)
        }
        return total
    }
    
    fun Move(name:String):Int{
        val q=ArrayDeque<Node>()
        
        val initCheck=BooleanArray(name.length){false}
        
        for(i in name.indices){
            if(name[i]=='A') initCheck[i]=true
        }
        
        q.addLast(Node(0,0,initCheck))
        
        var min=Int.MAX_VALUE
        while(q.isNotEmpty()){
            val cur=q.removeFirst()
            
            if(!cur.check.contains(false)){
                min=minOf(min,cur.total)
                continue
            } 
            
            var left=0
            var idxl=0
            while(true){
                idxl=cur.cur -left
                if(idxl<0) idxl+=name.length
                if(!cur.check[idxl]) break
                left++
            }
            
            var right=0
            var idxr=0
            while(true){
                idxr=cur.cur + right
                if(idxr>=name.length) idxr-=name.length
                if(!cur.check[idxr]) break
                right++
            }
            val node1 = Node(idxl,left+cur.total,cur.check.copyOf().apply{this[idxl]=true})
            val node2 = Node(idxr,right+cur.total,cur.check.copyOf().apply{this[idxr]=true})
            
            q.addLast(node1)
            q.addLast(node2)
            
            
        }
        return min
    }
}

data class Node(val cur:Int, var total:Int, var check:BooleanArray)