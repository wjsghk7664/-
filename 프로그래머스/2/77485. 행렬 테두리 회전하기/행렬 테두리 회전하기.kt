class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val arr=Array(rows){IntArray(columns)}
        for(i in 0..rows*columns-1){
            arr[i/columns][i%columns]=i+1
        }
        for(i in queries){
            val qtop=ArrayDeque<Int>()
            val qleft=ArrayDeque<Int>()
            val qright=ArrayDeque<Int>()
            val qbot=ArrayDeque<Int>()
            
            val q=intArrayOf(i[0]-1,i[1]-1,i[2]-1,i[3]-1)
            
            var min=Int.MAX_VALUE
            for(j in q[1]..q[3]){
                qtop.addLast(arr[q[0]][j])
                qbot.addLast(arr[q[2]][j])
                min=minOf(min,arr[q[0]][j])
                min=minOf(min,arr[q[2]][j])
            }
            if(q[0]<=q[2]-2){
                for(j in q[0]+1..q[2]-1){
                    qleft.addLast(arr[j][q[1]])
                    qright.addLast(arr[j][q[3]])
                    min=minOf(min,arr[j][q[1]])
                    min=minOf(min,arr[j][q[3]])
                }
                qtop.addFirst(qleft.removeFirst())
                qright.addFirst(qtop.removeLast())
                qbot.addLast(qright.removeLast())
                qleft.addLast(qbot.removeFirst())
                
                for(j in q[1]..q[3]){
                    arr[q[0]][j]=qtop.removeFirst()
                    arr[q[2]][j]=qbot.removeFirst()
                }
                for(j in q[0]+1..q[2]-1){
                    arr[j][q[1]]=qleft.removeFirst()
                    arr[j][q[3]]=qright.removeFirst()
                }
                
            }
            else{
                qtop.addFirst(qbot.removeFirst())
                qbot.addLast(qtop.removeLast())
                for(j in q[1]..q[3]){
                    arr[q[0]][j]=qtop.removeFirst()
                    arr[q[2]][j]=qbot.removeFirst()
                }
            }
            answer+=min
            
            
            
        }
        return answer
    }
}