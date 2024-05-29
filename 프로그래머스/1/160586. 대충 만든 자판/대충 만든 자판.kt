class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var map=mutableMapOf<Char,Int>()
        for(i:Char in 'A'..'Z'){
            map.put(i,-1)
        }
        for(i:String in keymap){
            for(j:Int in 0..i.length-1){
                //체크할 알파벳
                var tmp=i[j]
                //현재 해당 알파벳의 입력을 위한 클릭수
                val mtmp=map[tmp]?:throw IllegalArgumentException()
                
                //해당 알파벳 입력법이 처음 나왔거나 앞서 저장한 알파벳 입력법보다 입력횟수가 적은경우
                if(mtmp==-1||(mtmp>-1&&mtmp>j)){
                    map[tmp]=j+1
                }
            }
        }
        
        for(i:String in targets){
            var total=0
            for(j:Char in i){
                val tmp=map[j]?:throw IllegalArgumentException()
                if(tmp==-1){
                    total=-1
                    break
                }
                total+=tmp
            }
            answer+=total
            
        }
        
        
        return answer
    }
}