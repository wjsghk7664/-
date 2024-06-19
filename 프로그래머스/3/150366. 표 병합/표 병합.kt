class Solution {
    fun solution(commands: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val nodes=ArrayList<ArrayList<Node>>()
        for(i in 0..50){
            val arr=ArrayList<Node>()
            for(j in 0..50){
                arr+=Node(i,j)
            }
            nodes+=arr
        }
        
        for(i in commands){
            val command=i.split(" ")
            when(command[0]){
                "UPDATE" -> run{
                    if(command.size==4){
                        update1(nodes,command[1].toInt(),command[2].toInt(),command[3])
                    }else{
                        update2(nodes,command[1],command[2])
                    }
                }
                "MERGE" -> run{
                    merge(nodes,command[1].toInt(),command[2].toInt(),command[3].toInt(),command[4].toInt())
                }
                "UNMERGE" -> run{
                    unmerge(nodes,command[1].toInt(),command[2].toInt())
                }
                else -> run{
                    answer+=prints(nodes,command[1].toInt(),command[2].toInt())
                }
            }
        }
        
        return answer
    }
    
    fun update1(nodes:ArrayList<ArrayList<Node>>,r:Int,c:Int,values:String?){
        var cur=nodes[r][c]
        while(cur!=cur.head){
            cur=cur.head
        }
        cur.value=values
    }
    
    fun update2(nodes:ArrayList<ArrayList<Node>>,value1:String?, value2:String?){
        for(i in 1..50){
            for(j in 1..50){
                //어차피 전체 탐색이라 최상단 헤드도 자동 탐색되므로 타고올라갈필요 없음
                if(nodes[i][j].value==value1){
                    nodes[i][j].value=value2
                }
            }
        }
    }
    
    fun merge(nodes:ArrayList<ArrayList<Node>>,r1:Int,c1:Int,r2:Int,c2:Int){
        //최상단 끼리 비교하여 r1 c1위치의 값을 정함
        //r1 c1의 최하단에 r2 c2를 붙임
        var cur1=nodes[r1][c1]
        var cur2=nodes[r2][c2]
        
        while(cur1!=cur1.head){
            cur1=cur1.head
        }
        while(cur2!=cur2.head){
            cur2=cur2.head
        }
        if(cur1==cur2) return 
        
        if(cur1.value==null){
            cur1.value=cur2.value
        }
        while(cur1!=cur1.tail){
            cur1=cur1.tail
        }
        cur1.tail=cur2
        cur2.head=cur1 
    }
    
    fun unmerge(nodes:ArrayList<ArrayList<Node>>,r:Int,c:Int){
        var fix=nodes[r][c]
        var cur=fix
        while(cur!=cur.head){
            cur=cur.head
        }
        val tmpValue=cur.value
        while(cur!=cur.tail){
            cur.value=null
            cur.head=cur
            cur=cur.tail
            cur.head.tail=cur.head
        }
        cur.value=null
        cur.head=cur
        cur=cur.tail
        cur.head.tail=cur.head
        fix.value=tmpValue
    }
    
    fun prints(nodes:ArrayList<ArrayList<Node>>,r:Int,c:Int):String{
        var cur=nodes[r][c]
        while(cur!=cur.head){
            cur=cur.head
        }
        if(cur.value==null){
            return "EMPTY"
        }else{
            return cur.value as String
        }
    }
}

class Node(val x:Int, val y:Int){
    var value:String?=null
    var head:Node=this
    var tail:Node=this
}