class Solution {
    fun solution(clockHands: Array<IntArray>): Int {
        var answer: Int = 0
        val n=clockHands.size
        var min=Int.MAX_VALUE


        val rot=IntArray(n){0} //회전체크

        while(true){
            val copy=copy(clockHands)
            var rotNum=0

            //rot로 첫줄회전
            for(i in rot.indices){
                rotation(copy,0,i,rot[i])
                rotNum+=rot[i]
            }

            //아래 줄들 회전
            for(i in 1..n-1){
                for(j in 0..n-1){
                    val rotTmp=(4-copy[i-1][j])%4
                    rotation(copy,i,j,rotTmp)
                    rotNum+=rotTmp
                }
            }

            //맨아랫줄이 모두 0이면 min갱신
            if(copy[n-1].average()==0.0) min=minOf(min,rotNum)

            //rot끝 여부 체크 후 갱신
            if(rot.average()==3.0) break

            var idx=0
            while(true){
                rot[idx]+=1
                if(rot[idx]==4){
                    rot[idx++]=0
                }else{
                    break
                }
            }
        }

        return min
    }

    fun copy(arr:Array<IntArray>):Array<IntArray>{
        val tmp=Array(arr.size){IntArray(arr.size){0}}
        for(i in arr.indices){
            for(j in arr[0].indices){
                tmp[i][j]=arr[i][j]
            }
        }
        return tmp
    }

    fun rotation(arr:Array<IntArray>,x:Int,y:Int,n:Int){
        try{
            arr[x][y]+=n
            arr[x][y]%=4
        }catch(e:Exception){}
        try{
            arr[x+1][y]+=n
            arr[x+1][y]%=4
        }catch(e:Exception){}
        try{
            arr[x-1][y]+=n
            arr[x-1][y]%=4
        }catch(e:Exception){}
        try{
            arr[x][y+1]+=n
            arr[x][y+1]%=4
        }catch(e:Exception){}
        try{
            arr[x][y-1]+=n
            arr[x][y-1]%=4
        }catch(e:Exception){}
    }



}