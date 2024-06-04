class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var current=arrayOf(-1,-1)
        
        //시작위치 지정
        for(i:Int in 0..park.size-1){
            for(j:Int in 0..park[0].length-1){
                if(park[i][j]=='S'){
                    current[0]=i
                    current[1]=j
                    break
                }
            }
        }
        
        
        for(i:Int in 0..routes.size-1){
            val tmp=routes[i].split(" ")
            val dir=tmp[0]
            val len=tmp[1].toInt()
            val cur=current.copyOf()
            var flag=true
            var idx=1
            
            if(dir=="E"){
                var parkLen=park[0].length
                while(idx++<=len){
                    ++cur[1]
                    if(cur[1]>=parkLen){
                        flag=false
                        break
                    }else if(park[cur[0]][cur[1]]=='X'){
                        flag=false
                        break
                    }
                    
                }
            }
            
            if(dir=="W"){
                while(idx++<=len){
                    --cur[1]
                    if(cur[1]<0){
                        flag=false
                        break
                    }else if(park[cur[0]][cur[1]]=='X'){
                        flag=false
                        break
                    }
                    
                }
            }
            
            if(dir=="S"){
                var parkLen=park.size
                while(idx++<=len){
                    ++cur[0]
                    if(cur[0]>=parkLen){
                        flag=false
                        break
                    }
                    else if(park[cur[0]][cur[1]]=='X'){
                        flag=false
                        break
                    }
                    
                }
            }
            
            if(dir=="N"){
                while(idx++<=len){
                    --cur[0]
                    if(cur[0]<0){
                        flag=false
                        break
                    }else if(park[cur[0]][cur[1]]=='X'){
                        flag=false
                        break
                    }
                    
                }
            }
            if(flag){
                current=cur
            }
        }
        answer=current.toIntArray()
        
        return answer
    }
}