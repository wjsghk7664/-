class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var map=mutableMapOf<Char,Int>('R' to 0, 'T' to 0, 'C' to 0,'F' to 0, 'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0)
        for(i:Int in 0..choices.size-1){
            var tmp=choices[i]
            if(tmp<4){
                map[survey[i][0]]=map[survey[i][0]]!!.plus(when(tmp){
                    1 -> 3
                    2 -> 2
                    else -> 1
                })
            }else if(tmp>4){
                map[survey[i][1]]=map[survey[i][1]]!!.plus(when(tmp){
                    5 -> 1
                    6 -> 2
                    else -> 3
                })
            }
        }
        
        answer+=if(map['T']?:0>map['R']?:0) "T" else "R"
        answer+=if(map['F']?:0>map['C']?:0) "F" else "C"
        answer+=if(map['M']?:0>map['J']?:0) "M" else "J"
        answer+=if(map['N']?:0>map['A']?:0) "N" else "A"
        
        return answer
    }
}