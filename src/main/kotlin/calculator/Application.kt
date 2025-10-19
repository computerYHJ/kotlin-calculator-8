package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {

    println("덧셈할 문자열을 입력해주세요")
    var Input: String = readLine()

    var NoNumberRegex = Regex("[1-9]+")
    if(!NoNumberRegex.containsMatchIn(Input)){
        throw IllegalArgumentException("숫자가 포함된 문자열을 입력해주세요.")
    }

    var Separator = mutableListOf(':',',')

    val Customregex = Regex("//(.)\\\\n(.*)")
    val match = Customregex.find(Input)
    if (match != null) {
        Separator.add(match.groupValues[1][0])
        Input = match.groupValues[2]
    }

    for(i in 0 until Separator.count()){
        Input = Input.replace(Separator[i],'*')
    }

    var NumberArray = Input.split('*')

    var answer = 0

    for(i in 0 until NumberArray.count()){
        try {
            var IntegerNumber = Integer.parseInt(NumberArray[i])
            if(IntegerNumber < 0) throw NumberFormatException()
            else answer += IntegerNumber
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
    print("결과 : $answer")
}
