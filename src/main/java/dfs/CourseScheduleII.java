package dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CourseScheduleII {
    private final ConcurrentHashMap<Integer, List<Integer>> courseToPrerequisites = new ConcurrentHashMap<>();
    // if traverse to hit visited, then it has a cycle.
    private final HashSet<Integer> visited = new HashSet<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {


        // 1. build prerequisite table
        for (int i = 0; i < numCourses; i++) {
            courseToPrerequisites.put(i, new LinkedList<>());
        }
        for (final int[] prerequisite : prerequisites) {
            courseToPrerequisites.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] result = new int[numCourses];




        return result;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            // there is a cycle
            return false;
        }

        visited.add(course);
        return false;
    }
}
