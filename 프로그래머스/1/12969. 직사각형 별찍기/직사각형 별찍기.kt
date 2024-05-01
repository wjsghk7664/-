fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for(i:Int in 1..b){
        for(j:Int in 1..a){
            print('*')
        }
        print('\n')
    }
}