package kakao;

import java.util.PriorityQueue;

public class kakao2018_2 {
		public int[] solution(int N, int[] stages) {
		        int[][] failRates = new int[N+1][2];
		        // failRate[2][1] 은 3번 스테이지에 도달한 플레이어 수
		        // failRate[4][0] 은 5번 스테이지에 도달했으나 클리어 못한 플레이어 수
		               
		        for(int i=0; i<stages.length; i++) {
		            for(int j=1; j<stages[i]; j++) {
		                failRates[j][0]++;
		                failRates[j][1]++;
		               }
		            if(stages[i] <= N) failRates[stages[i]][0]++;
		        }
		        PriorityQueue<fR> pq = new PriorityQueue<>();
		
		        for(int i=1; i<=N; i++) {
		            fR fr = new fR(i, (double)failRates[i][1]/failRates[i][0]);
		            pq.add(fr);
		        }
		
		        int[] answer = new int[N];
		        for(int i=0; i<N; i++) {
		            answer[i] = pq.poll().stage;
		        }
		        return answer;
		}
}

class fR implements Comparable<fR>{
        int stage;
        double failRate;
        public fR(int stage, double failRate) {
                this.stage = stage;
                this.failRate = failRate;
        }
            
        @Override
        public int compareTo(fR target) {
                if(this.failRate > target.failRate) return 1;
                else if(this.failRate < target.failRate) return -1;
                else {
                	if(this.stage > target.stage) return 1;
                	else if(this.stage < target.stage) return -1;
                	else return 0;
                }
        }
}
