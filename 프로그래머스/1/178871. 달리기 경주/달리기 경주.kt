class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var map=mutableMapOf<String,Int>()
        for(i in 0..players.size-1){
            map.put(players[i],i)
        }
        var arr=players
        for(i in 0..callings.size-1){
            var calledName=callings[i]
            var calledRank=map[calledName]
            var frontName=arr[calledRank!!-1]
            var frontRank=calledRank!!-1
            
            //map 수정
            var tmpR=calledRank
            map[calledName]=frontRank
            map[frontName]=tmpR!!
            
            //arr 수정
            var tmpN=calledName
            arr[calledRank]=frontName
            arr[frontRank]=tmpN
        }
        answer=arr
        return answer
    }
}