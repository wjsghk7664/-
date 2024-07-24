class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        data.sortWith(compareBy({it[col-1]},{-it[0]}))

        answer=data[row_begin-1].map{it%(row_begin)}.sum()
        for(i in row_begin+1..row_end){
            println(answer)
            answer= answer xor data[i-1].map{it%i}.sum()
        }
        return answer
    }
}