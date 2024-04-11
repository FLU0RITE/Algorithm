import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val totalRepeatNum = br.readLine().toInt()
    var heap = mutableListOf<Int>()
    var pointer = -1
    repeat(totalRepeatNum) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (heap.isEmpty()) {
                bw.write("0\n")
            } else {
                bw.write("${heap[0]}\n")
                heap[0] = heap[pointer]
                heap.removeAt(pointer)
                pointer -= 1
                heap = downHeap(heap, 0)
            }
        } else {
            heap.add(num)
            pointer += 1
            heap = upHeap(heap, pointer)
        }
    }

    bw.flush()
    bw.close()
}

fun swap(heap: MutableList<Int>, index: Int, index2: Int): MutableList<Int> {
    val temp = heap[index]
    heap[index] = heap[index2]
    heap[index2] = temp

    return heap
}

fun downHeap(heap: MutableList<Int>, index: Int): MutableList<Int> {
    var heap = heap
    if (index * 2 + 2 <= heap.size-1) {
        if (heap[index * 2 + 1] < heap[index * 2 + 2]) {
            if (heap[index] > heap[index * 2 + 1]) {
                heap = swap(heap, index, index * 2 + 1)
                downHeap(heap, index * 2 + 1)
            }
        } else {
            if (heap[index] > heap[index * 2 + 2]) {
                heap = swap(heap, index, index * 2 + 2)
                downHeap(heap, index * 2 + 2)
            }
        }
    } else if (index * 2 + 1 <= heap.size-1) {
        if (heap[index] > heap[index * 2 + 1]) {
            heap = swap(heap, index, index * 2 + 1)
            return heap
        }
    } else {
        return heap
    }

    return heap
}

fun upHeap(heap: MutableList<Int>, index: Int): MutableList<Int> {
    var heap = heap
    if (index == 0) {
        return heap
    } else {
        if (heap[index] < heap[(index - 1) / 2]) {
            heap = swap(heap, index, (index - 1) / 2)
            upHeap(heap, (index - 1) / 2)
        }
    }

    return heap
}