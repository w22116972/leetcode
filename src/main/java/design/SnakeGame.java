package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeGame {

    private Queue<Axis> snake = new LinkedList<>();
    private List<List<Integer>> board = new ArrayList<>();
    private final Integer maxWidth;
    private final Integer maxHeight;
    private Axis currentFood;
    private Integer foodIndex = 0;

    public SnakeGame(int width, int height, int[][] food) {
        maxWidth = width - 1;
        maxHeight = height - 1;
        currentFood = new Axis(food[foodIndex][0], food[foodIndex][1]);
    }

    public int move(String direction) {
        return -1;
    }

    static class Axis {
        private Integer x;
        private Integer y;

        public Axis(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        void move(String direction) {
            if (direction.equals("U")) {
                this.y++;
            } else if (direction.equals("D")) {
                this.y--;
            } else if (direction.equals("L")) {
                this.x--;
            } else if (direction.equals("R")) {
                this.x++;
            }
        }
    }
}
