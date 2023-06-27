package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ_2042
 */
public class BOJ_2042 {
    public static void main(String[] args) throws IOException{
        // 입출력을 위한 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N,M,K 입력
        // N 은 입력 숫자의 갯수
        // M 은 변경이 일어나는 횟수
        // K 는 구간의 합을 구하는 횟수
        int N, M, K;

        String[] input = br.readLine().toString().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        SegmentTree segmentTree = new SegmentTree(N);

        long[] inputNumber = new long[N+1];
        setInputNumberArray(inputNumber, N, br);

        System.out.println(segmentTree.init(inputNumber, 1, 1, N));
        System.out.println(segmentTree.sum(1,1,N,2,4));
        System.out.println(segmentTree.update(1, 1, N, 7, 2));
        System.out.println(segmentTree.sum(1,1,N,2,4));

    }

    private static void setInputNumberArray(long[] inputNumber, int N, BufferedReader br) throws IOException{
        for(int i = 1 ; i <= N ; i++){
            inputNumber[i] = Long.parseLong(br.readLine());
        }
    }

    static class SegmentTree {
        // Segment Tree
        private long[] tree;

        SegmentTree(int n) {
            // Tree 높이 계산
            // Tree 높이 = (log n / log 2) + 1 의 smallest 정수
            double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
            // Node 총 개수 계산
            // Node 총 개수 = 2 ^ treeHieght 의 근접 long 형 정수
            long nodeCount = Math.round(Math.pow(2, treeHeight));

            tree = new long[Math.toIntExact(nodeCount)];

        }

        long init (long [] arr, int node, int start, int end) {

            if(start == end) {
                return tree[node] = arr[start];
            }
            return tree[node] = init(arr, node*2 , start, (start+end)/2) + init(arr, node*2+1, (start+end)/2+1,end);
        }

        long sum (int node, int start, int end, int left, int right) {
            if (end < left || start > right) return 0;
            else if (left <= start && end <= right) return tree[node];
            else return sum (node * 2 , start , (start+end)/2, left,right) + sum (node * 2 + 1, (start+end)/2+1, end, left, right);
        }

        long update (int node, int start, int end, long value, int target) {
            if (end < target || start > target) return 0;
            else if (start == target && end == target) return tree[node] = value;
            else return update (node * 2, start, (start+end)/2, value, target) + update (node * 2 + 1, (start+end)/2+1, end, value, target); 
        }
    }
}