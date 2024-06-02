class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        var w=wallpaper[0].length-1
        var h=wallpaper.size-1
        
        
        for(i:Int in 0..h){
            if(wallpaper[i].contains('#')){
                answer+=i
                break
            }
        }
        
        for(i:Int in 0..w){
            for(j:Int in 0..h){
                if (wallpaper[j][i]=='#'){
                    answer+=i
                    break
                }
            }
            if(answer.size==2){
                break
            }
        }
        
        
        for(i:Int in h downTo 0){
            if(wallpaper[i].contains('#')){
                answer+=i+1
                break
            }
        }
        
        for(i:Int in w downTo 0){
            for(j:Int in 0..h){
                if (wallpaper[j][i]=='#'){
                    answer+=i+1
                    break
                }
            }
            if(answer.size==4){
                break
            }
        }
        
        
        return answer
    }
}