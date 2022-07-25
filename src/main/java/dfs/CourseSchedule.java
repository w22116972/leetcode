package dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CourseSchedule {

    final ConcurrentHashMap<Integer, List<Integer>> courseToPrerequisites = new ConcurrentHashMap<>();
    final HashSet<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            courseToPrerequisites.put(i, new LinkedList<>());
        }
        for (final int[] prerequisite : prerequisites) {
            courseToPrerequisites.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    // can this course be finished
    public boolean dfs(int courseNumber) {
        if (visited.contains(courseNumber)) {
            return false;
        } else if (courseToPrerequisites.get(courseNumber).isEmpty()) {
            return true;
        }
        visited.add(courseNumber);
        for (Integer prerequisiteCourse : courseToPrerequisites.get(courseNumber)) {
            if (!dfs(prerequisiteCourse)) {
                return false;
            }
        }
        visited.remove(courseNumber);
        courseToPrerequisites.put(courseNumber, new LinkedList<>());
        return true;


    }
}
