class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var date=0
        date=when(a){
            1->0
            2->31
            3->60
            4->91
            5->121
            6->152
            7->182
            8->213
            9->244
            10->274
            11->305
            else->335
        }
        date+=b-1
        answer=when(date%7){
            0 -> "FRI"
            1 -> "SAT"
            2 -> "SUN"
            3 -> "MON"
            4 -> "TUE"
            5 -> "WED"
            else -> "THU"
        }
        return answer
    }
}