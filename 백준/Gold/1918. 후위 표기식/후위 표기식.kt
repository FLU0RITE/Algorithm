import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val answer = StringBuilder()
    val stack = Stack<Char>()
    val input: String = readLine()
    val line = input.toCharArray()
    
    for (i in line.indices) {
        if (line[i].code >= 65 && line[i].code <= 90) {
            answer.append(line[i])
        } else if (line[i] == '(') {
            stack.push(line[i])
        } else if (line[i] == ')') {
            if (!stack.empty()) {
                while (stack.peek() != '(') {
                    answer.append(stack.pop())
                }
                stack.pop()
            }
        } else if (line[i] == '*' || line[i] == '/') {
            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                answer.append(stack.pop())
            }
            stack.push(line[i])
        } else if (line[i] == '+' || line[i] == '-') {
            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
                answer.append(stack.pop())
            }
            stack.push(line[i])
        }
    }

    while (!stack.empty()) {
        answer.append(stack.pop())
    }
    println(answer)
}








