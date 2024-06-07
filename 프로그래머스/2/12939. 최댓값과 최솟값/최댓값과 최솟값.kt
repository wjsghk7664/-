class Solution {
    fun solution(s: String): String {
        var list=s.split(" ")
        var arr=arrayOf<Int>()
        list.forEach{arr+=it.toInt()}
        return "${arr.minOrNull()} ${arr.maxOrNull()}"
    }
}