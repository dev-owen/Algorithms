package kakao;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int nFoods = food_times.length;
        for (int i = 0; i < nFoods; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        long remainingTime = k;
        while (!foods.isEmpty()) {
            int nRemainingFoods = foods.size();
            int eachTimes = (int) (remainingTime / nRemainingFoods);
            remainingTime = remainingTime % nRemainingFoods;
            if (eachTimes == 0) {
                return foods.get((int) remainingTime).id;
            }

            long overflow = eatEach(foods, eachTimes);
            remainingTime += overflow;
        }

        return -1;
    }

    private long eatEach(List<Food> foods, int t) {
        long overflow = 0;
        for (Food f : foods) {
            f.remainingTime -= t;
            if (f.remainingTime < 0) {
                overflow += -f.remainingTime;
            }
        }
        foods.removeIf(f -> f.remainingTime <= 0);
        return overflow;
    }

    class Food {
        public int id;
        public int remainingTime;

        public Food (int id_, int t) {
            id = id_;
            remainingTime = t;
        }
    }
}