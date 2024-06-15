class Solution {
    fun solution(coin: Int, cards: IntArray): Int {
        var answer: Int = 0
        val n=cards.size
        var coins=coin
        var idx=n/3-1
        //initset 초기화후 pair 수와 unpairedset을 남겨둠
        //뽑은 카드는 picked에 넣음
        //매 라운드마다 picked에 카드 두장씩을 넣으면서 비교 없으면 종료
        //코인 2개이상일때 unpaired와 쌍을 이루는 카드가 두장이상 있으면 추가
        //코인 1개 이상일때 unpaired와 쌍을 이루는 카드가 한장이상 있으면 추가
        //코인이 2개이상인데 pair가 0이면 picked에서 쌍을 이루는 2장 가져와서 pair 1상승
        //이후 pair체크 후 1감소시키고 다음라운드. 감소시킬값이 없으면 종료
        
        val unpaired=hashSetOf<Int>()
        for(i in 0..n/3-1){
            unpaired.add(cards[i])
        }
        var pair=0
        
        val removed=hashSetOf<Int>()
        for(i in unpaired){
            for(j in unpaired){
                if(i>=j) continue
                if(n+1-i==j){
                    removed.add(i)
                    removed.add(j)
                    ++pair
                }
            }
        }
        
        var round=0
        
        //picked와 unpaired를 미리 체크해서 페어해두는것
        //매번 picked전체와 unpaired전체를 비교할필요 없이 비교 수를 최소화함.
        var pickedpaired=0 
        val picked=hashSetOf<Int>()
        while(true){
            println("${round}/${pair}")
            ++round
            if(idx==n-1){
                break
            }
            
            repeat(2) {
                val tmp=cards[++idx]
                var remove=0 //0은 없는 원소니깐 제거시도시 문제 없음
                for(i in unpaired){
                    if(n+1-tmp==i){
                        remove=i
                        pickedpaired++
                        break
                    }
                }
                if(remove==0){
                    picked.add(tmp)
                }else{
                    unpaired.remove(remove)  
                }
                
            }
            
            
            
            if(coins>=2){
                if(pickedpaired>=2){
                    pickedpaired-=2
                    pair++
                    coins-=2

                    continue
                }
            }
            if(coins>=1){
                if(pickedpaired>=1){
                    pickedpaired--
                    coins--
                    continue
                }
            }
            if(coins>=2&&pair==0){
                val removed=hashSetOf<Int>()
                var flag=false
                for(i in picked){
                    for(j in picked){
                        if(i>=j) continue
                        if(n+1-i==j){
                            removed.add(i)
                            removed.add(j)
                            flag=true
                            break
                        }
                    }
                    if(flag) {
                        break
                    }
                }
                if(flag){
                    picked.removeAll(removed)
                    coins-=2
                    continue 
                }
                
            }
            if(pair==0) break
            pair--   
        }

        return round
    }
}


