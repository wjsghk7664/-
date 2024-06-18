class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = 0
        //카데인 알고리즘 이용
        val arr=Array(2){LongArray(sequence.size){0}}
        arr[0][0]=sequence[0].toLong()
        arr[1][0]=-1L*sequence[0].toLong()
        for(i in 1..sequence.size-1){
            if(i%2==0){
                arr[0][i]=maxOf(sequence[i].toLong(),arr[0][i-1]+sequence[i].toLong())
                arr[1][i]=maxOf(sequence[i].toLong()*-1L,arr[1][i-1]+sequence[i].toLong()*-1L)
            }else{
                arr[0][i]=maxOf(sequence[i].toLong()*-1L,arr[0][i-1]+sequence[i].toLong()*-1L)
                arr[1][i]=maxOf(sequence[i].toLong(),arr[1][i-1]+sequence[i].toLong())
            }
        }

        return maxOf(arr[0].maxOrNull()!!,arr[1].maxOrNull()!!)
    }
}