class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var tmp=ingredient.toMutableList()
        var idx=0
        while(idx<tmp.size){
            if(idx<3) {
                ++idx
                continue
            }
            
            if(tmp[idx-3]==1&&tmp[idx-2]==2&&tmp[idx-1]==3&&tmp[idx]==1){
                tmp.removeAt(idx-3)
                tmp.removeAt(idx-3)
                tmp.removeAt(idx-3)
                tmp.removeAt(idx-3)
                idx-=3
                answer++
            }else{
                ++idx
            }
        
        }
        return answer
    }
    
}