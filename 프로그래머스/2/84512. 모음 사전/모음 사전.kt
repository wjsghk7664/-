class Solution {
    fun solution(word: String): Int {
        var answer = 1
        //AXXXX부터 시작
        //순서는 X A E I O U순
        var str=charArrayOf('A','X','X','X','X')
        try{
            while(true){
            
                if(word==str.joinToString().replace(", ", "").replace("X","")) return answer

                var idx=4
                while(true){
                    if(str[idx-1]=='X') idx--
                    else break
                }
                while(true){
                    str[idx]=when(str[idx]){
                        'X' -> 'A'
                        'A' -> 'E' 
                        'E' -> 'I'
                        'I' -> 'O'
                        'O' -> 'U'
                        else ->'X'
                    }
                    if(str[idx]=='X'){
                        idx--
                    }else{
                        break
                    }
                } 
                answer++
            }
        }catch(e:Exception){
            println("${str}")
        }
        
        return answer
    }
}