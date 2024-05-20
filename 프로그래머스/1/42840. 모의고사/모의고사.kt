class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        var s1=0
        var s1a=intArrayOf(1,2,3,4,5)
        var s2=0
        var s2a=intArrayOf(2,1,2,3,2,4,2,5)
        var s3=0
        var s3a=intArrayOf(3,3,1,1,2,2,4,4,5,5)
        
        for(i:Int in 0..answers.size-1){
            if(s1a[i%5]==answers[i]){
                s1++
            }
            if(s2a[i%8]==answers[i]){
                s2++
            }
            if(s3a[i%10]==answers[i]){
                s3++
            }
        }
        if(s1!=0||s2!=0||s3!=0){
            answer=if(s1==s2&&s2==s3){
                intArrayOf(1,2,3)
            }
            else if(s1>s2&&s1>s3){
                intArrayOf(1)
            }
            else if(s2>s1&&s2>s3){
                intArrayOf(2)
            }
            else if(s3>s1&&s3>s2){
                intArrayOf(3)
            }
            else if(s1==s2){
                intArrayOf(1,2)
            }
            else if(s2==s3){
                intArrayOf(2,3)
            }
            else{
                intArrayOf(1,3)
            }
        }
        return answer
    }
}