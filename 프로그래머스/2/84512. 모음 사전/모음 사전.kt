class Solution {
    fun solution(word: String): Int {
        var answer = 0
        var first = 1 + 5 + 5*5 + 5*5*5 + 5*5*5*5
        var second = 1 + 5 + 5*5 + 5*5*5
        var third = 1 + 5 + 5*5
        var fourth = 1 + 5
        var fifth = 1
        
        answer+=when(word[0]){
            'A' -> 0
            'E' -> first
            'I' -> first*2
            'O' -> first*3
            'U' -> first*4
            else -> 0
        }
        
        answer+=1
        
        if(word.length==1) return answer
        
        answer+=when(word[1]){
            'A' -> 0
            'E' -> second
            'I' -> second*2
            'O' -> second*3
            'U' -> second*4
            else -> 0
        }
        
        answer+=1
        
        if(word.length==2) return answer
        
        answer+=when(word[2]){
            'A' -> 0
            'E' -> third
            'I' -> third*2
            'O' -> third*3
            'U' -> third*4
            else -> 0
        }
        
        answer+=1
        
        if(word.length==3) return answer
        
        answer+=when(word[3]){
            'A' -> 0
            'E' -> fourth
            'I' -> fourth*2
            'O' -> fourth*3
            'U' -> fourth*4
            else -> 0
        }
        
        answer+=1
        
        if(word.length==4) return answer
        
        answer+=when(word[4]){
            'A' -> 1
            'E' -> 2
            'I' -> 3
            'O' -> 4
            'U' -> 5
            else -> 0
        }
        
        return answer
    }
}