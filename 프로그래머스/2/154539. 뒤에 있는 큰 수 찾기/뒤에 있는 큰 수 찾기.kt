class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer=IntArray(numbers.size){-1}

        for(i in numbers.size-2 downTo 0){
            for(j in i+1..numbers.size-1){
                if(numbers[i]<numbers[j]){
                    answer[i]=numbers[j]
                    break
                }
                //numbers[i]>=numbers[j]인 경우(i<j)
                //ni~nj까지 ni보다 큰 수가 없었는데 aj=-1이면 nj이후에도 ni보다 큰 수가 없다는뜻
                //즉 ai는 -1
                //만약 aj값이 ni보다 크면  ai는 aj
                else{
                    if(answer[j]==-1){
                        answer[i]=-1
                        break
                    }
                    else if(answer[j]>numbers[i]){
                        answer[i]=answer[j]
                        break
                    }
                }
            }
        }
        return answer
    }
}