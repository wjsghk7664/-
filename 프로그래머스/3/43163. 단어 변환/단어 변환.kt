class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        
        if(!words.contains(target)) return 0
        
        val nodes=Array(words.size){Node(words[it],it)}
        
        val arr=Array(words.size){IntArray(words.size)}
        
        for((i,v1) in words.withIndex()){
            for((j,v2) in words.withIndex()){
                if(checkWord(v1,v2)){
                    arr[i][j]=1
                    arr[j][i]=1
                }
            }
        }
        
        
        val q=ArrayDeque<Pair<Int,Int>>() //변환수, 인덱스
        
        for((i,v) in words.withIndex()){
            if(checkWord(begin,v)) {
                q.addLast(Pair(1,i))
            }
        }
        
        while(q.isNotEmpty()){
            val (num,cur) = q.removeFirst()
            println(words[cur]+":"+num.toString())
            
            if(num>words.size) continue
            
            if(target==words[cur]) return num
            
            for(i in words.indices){
                if(arr[cur][i]==1){
                    q.addLast(Pair(num+1,i))
                }
            }
        }
        return 0
    }
    
    fun checkWord(str1:String, str2:String):Boolean{
        var dif=0
        for(i in str1.indices){
            if(str1[i]!=str2[i]) ++dif
        }
        return if(dif==1) true else false
    }
}

data class Node(val word:String, val idx:Int)