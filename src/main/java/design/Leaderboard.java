package design;

import java.util.LinkedHashMap;

public class Leaderboard {
    private LinkedHashMap<Integer, Score> playerToScore;


    public Leaderboard() {
        this.playerToScore = new LinkedHashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (!this.playerToScore.containsKey(playerId)) {
            this.playerToScore.put(playerId, new Score(playerId, score));
        } else {
            this.playerToScore.get(playerId).addScore(score);
        }
    }

    public int top(int K) {
        return this.playerToScore.values().stream().sorted().limit(K).map(score -> score.score).reduce(Integer::sum)
                .orElse(0);
    }

    public void reset(int playerId) {
        this.playerToScore.get(playerId).reset();
    }

    static class Score implements Comparable<Score> {
        Integer playerId;
        Integer score;

        public Score(Integer playerId, Integer score) {
            this.playerId = playerId;
            this.score = score;
        }

        public void reset() {
            this.score = 0;
        }

        public void addScore(Integer addingScore) {
            this.score += addingScore;
        }

        // reverse order
        @Override
        public int compareTo(Score o) {
            return o.score - this.score ;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "playerId=" + playerId +
                    ", score=" + score +
                    '}';
        }
    }
}
