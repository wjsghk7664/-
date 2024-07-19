class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in places){
            answer+=room(i)
        }
        return answer
    }
    fun room(place:Array<String>):Int{
        for(i in place.indices){
            for((j,v) in place[i].withIndex()){
                if(v=='P'&&!check(i,j,place)) return 0
            }
        }
        return 1
    }
    fun check(i:Int, j:Int, place:Array<String>):Boolean{
        val dx=intArrayOf(0,0,1,-1)
        val dy=intArrayOf(1,-1,0,0)
        val visited=HashSet<Pair<Int,Int>>()
        val q=ArrayDeque<Triple<Int,Int,Int>>() //x,y,dist
        q.addLast(Triple(i,j,2))
        visited+=Pair(i,j)
        while(q.isNotEmpty()){
            val (x,y,dist) = q.removeFirst()
            if(place[x][y]=='P'&&dist<2) return false
            if(dist==0) continue
            
            for(k in 0..3){
                val nx=x+dx[k]
                val ny=y+dy[k]
                if(nx in 0..4&&ny in 0..4&&!visited.contains(Pair(nx,ny))&&place[x][y]!='X'){
                    visited+=Pair(nx,ny)
                    q.addLast(Triple(nx,ny,dist-1))
                }
            }
        }
        return true
    }
}