package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {

    println("덧셈할 문자열을 입력해주세요")
    var test_string: String = readLine()

    var NoNumberRegex = Regex("[1-9]+")
    if(!NoNumberRegex.containsMatchIn(test_string)){
        throw IllegalArgumentException("숫자가 포함된 문자열을 입력해주세요.")
    }

    var list = mutableListOf(':',',')

    val regex = Regex("//(.)\\\\n(.*)")
    val match = regex.find(test_string)
    if (match != null) {
        list.add(match.groupValues[1].get(0))
        test_string = match.groupValues[2]
    }

    for(i in 0 until list.count()){
        test_string = test_string.replace(list[i],'*')
    }

    var finalArray = test_string.split('*')

    var answer = 0

    for(i in 0 until finalArray.count()){
        try {
            answer += Integer.parseInt(finalArray[i])
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    print("결과 : $answer")

}
