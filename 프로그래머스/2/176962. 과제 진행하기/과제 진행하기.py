def solution(plans):
    answer = []
    sequence = {}
    stack = []
    cur = 0
    for i in range(len(plans)) :
        h,m = map(int,plans[i][1].split(":"))
        sequence[plans[i][0]] = [h*60+m,int(plans[i][2])]
    start = sorted(sequence.items(), key = lambda item : item[1][0], reverse = True)
    while True :
        
        if stack and cur < start[-1][1][0] :
            finish_time = cur + stack[-1][1][1]
            next_start = start[-1][1][0]
            if finish_time > next_start :
                time_spent = next_start - cur 
                stack[-1][1][1] -= time_spent # 남은 시간 업데이트
                cur = next_start # 현재 시간을 다음 과제 시작 시간으로 업데이트
            else : # 현재 과제 완료
                cur = finish_time # 현재 시간을 과제 종료 시간으로 업데이트
                answer.append(stack.pop()[0])
        else :
            stack.append(start.pop())
            if not start :
                while stack :
                    answer.append(stack.pop()[0])
                break
            if stack[-1][1][0] + stack[-1][1][1] > start[-1][1][0] :
                overFlow = start[-1][1][0] - stack[-1][1][0]
                stack[-1][1][1] -= overFlow
                cur = start[-1][1][0]
            else :
                cur = stack[-1][1][0] + stack[-1][1][1]
                answer.append(stack.pop()[0])
        
        
            

    
    return answer