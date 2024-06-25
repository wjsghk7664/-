class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = 0
        var st=k
        val sets=hashSetOf<IntArray>()
        for(i in dungeons) sets.add(i)
        return fac(sets,st,0)
    }
    
    fun fac(sets:HashSet<IntArray>,st:Int,total:Int):Int{
        val answers=ArrayList<Int>()
        for(i in sets){
            if(i[0]<=st){
                val tmpset=HashSet(sets)
                tmpset.remove(i)
                answers+=fac(tmpset,st-i[1],total+1)
            }
        }
        
        return answers.maxOrNull() ?: total
    }
}