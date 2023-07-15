package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;


/**
 * BOJ_27927
 */
public class BOJ_27927 {

    private static class Day implements Comparable<Day>{
        int start_day;
        int end_day;

        Day (int start_day, int end_day){
            this.start_day = start_day;
            this.end_day = end_day;
        }

        @Override
        public int compareTo(Day day) {
            return this.start_day - day.start_day;
        }

    }

    private static class SegTree_max {

        int[] data;
        int height=1;

        SegTree_max(int N) {
            while ((1 << height) < N ) {
                height++;
            }
            int size = 1 << (height + 1);
            data = new int[size];
        }

        int init(Day[] day_info, int now, int left, int right) {
            if (left == right) {
                return data[now] = day_info[left].start_day;
            }

            int next = now * 2;
            int mid = (left + right) / 2;

            return data[now]=Integer.max(init(day_info, next, left, mid), init(day_info, next+1, mid+1, right));
        }

        int query(int now, int left, int right, int L, int R) {
            if (right < L || left > R) {
                return Integer.MIN_VALUE;
            }

            if (L <= left && right <= R) {
                return data[now];
            }

            int next = now * 2;
            int mid = (left + right) / 2;

            return Integer.max(query(next, left, mid, L, R), query(next+1, mid+1, right, L, R));
        }
    }

    private static class SegTree_min {

        int[] data;
        int height=1;

        SegTree_min(int N) {
            while ((1 << height) < N ) {
                height++;
            }
            int size = 1 << (height + 1);
            data = new int[size];
        }

        int init(Day[] day_info, int now, int left, int right) {
            if (left == right) {
                return data[now] = day_info[left].end_day;
            }

            int next = now * 2;
            int mid = (left + right) / 2;

            return data[now]=Integer.min(init(day_info, next, left, mid), init(day_info, next+1, mid+1, right));
        }

        int query(int now, int left, int right, int L, int R) {
            if (right < L || left > R) {
                return Integer.MAX_VALUE;
            }

            if (L <= left && right <= R) {
                return data[now];
            }

            int next = now * 2;
            int mid = (left + right) / 2;

            return Integer.min(query(next, left, mid, L, R), query(next+1, mid+1, right, L, R));
        }
    }

    
    public static void main(String[] args) throws IOException{
        // 입출력을 위한 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N : 벚나무 개수
        // M : 축제기간
        String[] input_condition = br.readLine().split(" ");
        int N = Integer.parseInt(input_condition[0]);
        int M = Integer.parseInt(input_condition[1]);

        // 추가 input 입력
        Day[] day_info = new Day[N+1];
        for(int i = 0 ; i <  N ; i++){
            String[] input_data = br.readLine().split(" ");
            day_info[i] = new Day(Integer.parseInt(input_data[0]), Integer.parseInt(input_data[1]));
        }

        // seg_Tree Setting
        SegTree_min segTree_min = new SegTree_min(N);
        SegTree_max segTree_max = new SegTree_max(N);
        
        // Initialize
        segTree_min.init(day_info, 1, 0, N-1);
        segTree_max.init(day_info, 1, 0, N-1);

        int answer_1 = getMaxTree(segTree_min, segTree_max, N);
        int answer_2 = getMaxTreeDay(segTree_min, segTree_max, answer_1, N);
        bw.write(answer_1+ " " + answer_2);
        // 일렬로 연속해서 핀 벚나무 개수의 최댓값
        // int answer_1 = getMaxTree(day_info, N);
        // 가장 많은 벚나무가 일렬로 연속해서 핀 날의 개수
        // int answer_2 = getMaxDay();
        // bw.write(""+answer[0]+" "+answer[1]);
        // bw.write(""+answer_1);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMaxTreeDay(SegTree_min segTree_min, SegTree_max segTree_max, int max_tree_count, int N) {
        PriorityQueue<Day> pq = new PriorityQueue<>();
        for(int i = 0 ; i <= N-max_tree_count; i++){
            int start = segTree_max.query(1, 0, N - 1, i, i + max_tree_count-1);
            int end   = segTree_min.query(1, 0, N - 1, i, i + max_tree_count-1);
            if (start != Integer.MIN_VALUE && end != Integer.MAX_VALUE && end >= start) {
                pq.add(new Day(start, end));
            }
        }

        int answer = 0 ;
        int start_day = pq.peek().start_day;
        int end_day = pq.poll().end_day;
        
        while(!pq.isEmpty()){
            Day day = pq.poll();
            if(day.start_day > end_day) {
                answer += end_day - start_day + 1;
                start_day=day.start_day;
                end_day=day.end_day;
            }
            else {
                if(day.end_day > end_day) {
                    end_day = day.end_day;
                }
            }
        }
        return answer + end_day - start_day + 1;
    }

    private static int getMaxTree(SegTree_min segTree_min, SegTree_max segTree_max, int N) {
        int left = 0;
        int right = N+1;
        int max_tree = -1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if (isPossible(segTree_min, segTree_max, mid, N)) {
                max_tree = Integer.max(max_tree, mid);
                left = mid+1;
            }
            else {
                right = mid;
            }
        }

        return max_tree;
    }

    private static boolean isPossible(SegTree_min segTree_min, SegTree_max segTree_max, int tree_count, int max_tree_count) {
        for(int left = 0; left <= max_tree_count - tree_count; left++){
            int start = segTree_max.query(1, 0, max_tree_count - 1, left, left+tree_count-1);
            int end = segTree_min.query(1, 0, max_tree_count - 1, left, left+tree_count-1);
            if (start != Integer.MIN_VALUE && end != Integer.MAX_VALUE && end >= start) return true;
        }
        return false;
    }


}