class Solution {
    fun solution(target: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        val arr=ArrayList<Pair<Int,Int>>()
        arr+=Pair(0,0) //인덱스를 맞추기 위한 더미데이터
        
        //1-60까지 케이스로 나누어 베이스를 만들음
        //1-20: 싱글
        //50:불
        //21-40 %2:더블
        //21-60 %3:트리플
        //21-40:싱글 2
        //41-49:싱글 1 더블or트리플1
        //51-60:불1 싱글1
        
        
        for(i in 1..target){
            if(i in 1..20){
                arr+=Pair(1,1)
                continue
            }
            else if(i in 21..40&&i%2==0){
                arr+=Pair(1,0)
                continue
            }
            else if(i==50){
                arr+=Pair(1,1)
                continue
            }
            else if(i in 21..60&&i%3==0){
                arr+=Pair(1,0)
                continue
            }else if(i in 21..40){
                arr+=Pair(2,2)
                continue
            }else if(i in 41..49){
                arr+=Pair(2,1)
                continue
            }else if(i in 51..60){
                arr+=Pair(2,2)
                continue
            }
            
            var min=Int.MAX_VALUE
            var min2nd=0
            for(j in 1..20){
                for(k in 1..3){
                    val sum=arr[i-j*k].first+arr[j*k].first
                    val sum2nd=arr[i-j*k].second+arr[j*k].second
                    if(min>sum){
                        min=sum
                        min2nd=sum2nd
                    }else if(min==sum){
                        if(min2nd<sum2nd){
                            min2nd=sum2nd
                        }
                    }
                }
            }
            val sum=arr[i-50].first+arr[50].first
            val sum2nd=arr[i-50].second+arr[50].second
            if(min>sum){
                min=sum
                min2nd=sum2nd
            }else if(min==sum){
                if(min2nd<sum2nd){
                    min2nd=sum2nd
                }
            }
            
            arr+=Pair(min,min2nd)
        }
        val last=arr[arr.size-1]
        answer+=last.first
        answer+=last.second
    
        return answer
    }
    

    
}