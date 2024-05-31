
import java.util.PriorityQueue
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
    // jobs 배열을 요청 시간이 빠른 순으로 정렬합니다.
    jobs.sortBy { it[0] }
    
    // 현재 시간
    var currentTime = 0
    // 총 대기시간
    var totalWaitTime = 0
    // 작업의 인덱스
    var index = 0
    // 완료된 작업 수
    var completedJobs = 0
    // 작업을 관리할 우선순위 큐 (소요시간 기준으로 정렬)
    val heap = PriorityQueue(compareBy<IntArray> { it[1] })

    // 총 작업 수
    val n = jobs.size
    
    // 모든 작업이 처리될 때까지 반복합니다.
    while (completedJobs < n) {
        // 현재 시간까지 요청된 모든 작업을 힙에 추가합니다.
        while (index < n && jobs[index][0] <= currentTime) {
            heap.add(jobs[index])
            index++
        }
        
        if (heap.isNotEmpty()) {
            // 소요시간이 가장 짧은 작업을 꺼냅니다.
            val job = heap.poll()
            val jobDuration = job[1]
            val jobStartTime = job[0]
            currentTime += jobDuration
            totalWaitTime += (currentTime - jobStartTime)
            completedJobs++
        } else {
            // 힙이 비어있다면 다음 작업의 요청 시간으로 이동합니다.
            currentTime = jobs[index][0]
        }
    }
    
    // 평균 대기시간을 계산하여 반환합니다.
    return totalWaitTime / n
}

}