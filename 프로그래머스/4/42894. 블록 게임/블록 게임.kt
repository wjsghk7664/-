class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val head=Array(201){HashSet<Pair<Int,Int>>()}

        for(i in board.indices){
            for(j in board[0].indices){
                if(board[i][j]!=0) head[board[i][j]]+=Pair(i,j)
            }
        }


        val heads=HashSet<Int>()
        val upper=IntArray(board[0].size)
        for(i in board[0].indices){
            for(j in board.indices){
                if(board[j][i]!=0){
                    heads+=board[j][i]
                    upper[i]=j
                    break
                }
            }
        }
        while(true){
            val removed=HashSet<Int>()
            val added=HashSet<Int>()
            for(i in heads){
                val p=IntArray(8)
                var idx=0
                for(j in head[i]){
                    p[idx++]=j.first
                    p[idx++]=j.second
                }
                val blanks=blank(p)
                blanks?.let{
                    var flag=true
                    //반환받은 빈공간이나 그 위에 블럭이 있는지 체크

                    for(j in it){
                        if(j.first>=upper[j.second]) flag=false
                    }
                    if(flag){
                        answer++
                        //블럭 제거 후 해당열 upper와 heads갱신
                        for((x,y) in head[i]){
                            board[x][y]=0
                        }
                        for((x,y) in head[i]){
                            for(k in board.indices){
                                if(board[k][y]!=0){
                                    upper[y]=k
                                    added+=board[k][y]
                                    break
                                }
                            }
                        }
                        removed+=i
                    }
                }
            }
            if(removed.size==0) break
            
            heads.addAll(added)
            heads.removeAll(removed)
        }


        return answer
    }
    //가능한 타입:13,14,22,23,31
    //가능한 타입이면 빈공간을 반환, 아니면 널 반환
    fun blank(p:IntArray):Array<Pair<Int,Int>>?{
        //높이가 2가지 뿐이면 누운 타입
        val w=intArrayOf(p[1],p[3],p[5],p[7])
        val h=intArrayOf(p[0],p[2],p[4],p[6])

        //누운 타입
        if(h.distinct().size==2){
            //아래를 보는 누운타입이면 널 반환
            val up=h.minOrNull() as Int
            val down=h.maxOrNull() as Int
            var cnt=0
            h.forEach{if(it==down) ++cnt}
            if(cnt==1){
                return null
            }
            //타입에 따라 빈공간 반환
            val left=w.minOrNull() as Int
            val right=w.maxOrNull() as Int
            val center=w.filter{it!=left&&it!=right}[0]
            val upidx=h.indexOf(up)
            if(w[upidx]==left){
                return arrayOf(Pair(up,right),Pair(up,center))
            }else if(w[upidx]==right){
                return arrayOf(Pair(up,left),Pair(up,center))
            }else{
                return arrayOf(Pair(up,left),Pair(up,right))
            }
            //선 타입
        }else{
            //튀어나온 부분이 중앙이나 위에 있으면 널 반환
            val up=h.minOrNull() as Int
            val down=h.maxOrNull() as Int
            val center=h.filter{it!=up&&it!=down}[0]
            var cntCenter=0
            var cntUp=0
            h.forEach{if(it==up) ++cntUp else if(it==center) ++cntCenter}
            if(cntCenter==2||cntUp==2){
                return null
            }

            //타입에 따라 빈공간 반환
            val left=w.minOrNull() as Int
            val right=w.maxOrNull() as Int

            //좌측으로 튀어나온 경우
            if(w.filter{it==left}.size==1){
                return arrayOf(Pair(up,left),Pair(center,left))
                //우측으로 튀어나온 경우
            }else{
                return arrayOf(Pair(up,right),Pair(center,right))
            }
        }
    }
}