class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var answer = 0
        var sec=0L
        
        var maps=hashMapOf<Int,ArrayList<Int>>() //키는 음식수, 값은 해당 음식수를 갖는 인덱스들
        var foodIdx=0
        var sizes=food_times.size.toLong()
        
        var weight=0L
        
        
        var max=0
        for(i in food_times){
            if(i>max){
                max=i
            }
            maps.put(i,ArrayList<Int>())
        }
        
        for(i in food_times.indices){
            maps[food_times[i]]!!+=i
        }
        
        var tmpfood=maps.keys.sorted()
        
        var min=-1
        while(true){
            
            if(min==max){
                answer=-1
                break
            }
            
            min=tmpfood[foodIdx++]
            var cnt=maps[min]!!.size
            
            
            
            if(sec+sizes*(min.toLong()-weight)<=k){
                sec+=sizes*(min.toLong()-weight)
            }else{
                var move=(k-sec)%sizes
                for((key, value) in maps){
                    if(value.isEmpty()) continue
                    if(key<min){
                        for(i in value){
                            food_times[i]=0
                        }
                    }  
                }
                for(i in food_times.indices){
                    if(food_times[i]==0){
                        continue
                    }
                    if(move==0L){
                        answer=i+1
                        break
                    }
                    --move
                }
                break
            }
            
            sizes-=cnt
            weight=min.toLong()
            
            
        }
        
        
        return answer
    }
}