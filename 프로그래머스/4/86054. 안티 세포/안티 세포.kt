class Solution {
    val mod=(1e9 + 7).toLong()
    lateinit var hier:Array<HashMap<Long,Int>>
    lateinit var case:LongArray
    fun solution(a: IntArray, s: IntArray): IntArray {
        var answer: IntArray = IntArray(s.size)
        var l=0
        var r=0
        for(t in s.indices){
            val i=s[t]
            r=l+i-1
            //index는 우측 idx, 키는 합친 세포크기, 값은 좌측 idx
            hier=Array(i){hashMapOf<Long,Int>()}
            case=LongArray(i+1){0L}
            case[0]=1
            

            for(j in 0..i-1){
                case[j+1]=merge(a[j+l].toLong(),j,j)
            }
            answer[t]=(case[i]%mod).toInt()
            l=r+1
        }
        return answer
    }
    fun merge(initkey:Long,idx:Int,lidx:Int):Long{//idx는 계층 lidx는 좌측 인덱스
        var total=case[lidx]
        val curhier=hier[idx]
        curhier.getOrPut(initkey){lidx}

        if(lidx>0){
            hier[lidx-1][initkey]?.let{
                total+=merge(2*initkey,idx,it as Int)
                total%=mod
            }
        }
        

        return total
    }
}











