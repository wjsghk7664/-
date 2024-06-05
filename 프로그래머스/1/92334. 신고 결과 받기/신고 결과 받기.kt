class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var reportedMap=mutableMapOf<String,ArrayList<String>>() //키는 신고당한사람, 값은 신고한 사람목록
        var reportedNum=mutableMapOf<String,Int>() //키는 신고 당한사람, 값은 신고당한 횟수
        var result=mutableMapOf<String,Int>() //키는 신고한 사람, 값은 신고후 정지 메일 온 횟수
        
        for(i in id_list){
            reportedMap.put(i,ArrayList<String>())
            reportedNum.put(i,0)
            result.put(i,0)
        }
        
        //i는 신고한 사람의 index, j는 신고당한사람의 이름
        for(i in report){
            var tmp=i.split(" ") //tmp[0]는 신고한 사람, tmp[1]은 신고당한 사람
            if(!reportedMap[tmp[1]]!!.contains(tmp[0])){
                reportedMap[tmp[1]]!!.add(tmp[0])
                reportedNum[tmp[1]]=reportedNum[tmp[1]]!!.plus(1)
            }
        }
        
        
        for(i in id_list){
            if(reportedNum[i]!!>=k){
                reportedMap[i]?.forEach{
                    result[it]=result[it]!!.plus(1)
                }
            }
        }
        
        for(i in id_list){
            answer+=result[i]!!
        }
        
        return answer
    }
}