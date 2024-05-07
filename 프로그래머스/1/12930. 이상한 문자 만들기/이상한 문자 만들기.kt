class Solution {
    fun solution(s: String): String {
        var answer = ""
        var list=s.split(" ")
        for(i:Int in 0..list.size-1){
            for(j:Int in 0..list[i].length-1){
                if(j%2==0){
                    answer+=list[i][j].toUpperCase()
                }
                else{
                    answer+=list[i][j].toLowerCase()
                }
            }
            if(i!=list.size-1){
                answer+=" "
            }
            
        }
        return answer
    }
}