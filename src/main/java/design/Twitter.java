package design;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Twitter {

    public HashMap<Integer, User> users;
    private Integer time;

    public Twitter() {
        this.users = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        final List<Tweet> tweets = users.get(userId).tweets;
        tweets.add(new Tweet(tweetId, userId, time));
        tweets.sort(Comparator.comparingInt(x -> -x.time));
        users.get(userId).tweets = tweets.stream().limit(10).collect(Collectors.toList());
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
            return List.of();
        }
        final User user = users.get(userId);
        final Stream<Tweet> tweetStream = Stream.concat(user.followingIds.stream()
                .flatMap(id -> users.get(id).tweets.stream()), user.tweets.stream());
        return tweetStream.sorted(Comparator.comparingInt(x -> -x.time)).map(x -> x.tweetId).distinct().limit(10).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).followingIds.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        users.get(followerId).followingIds.remove(Integer.valueOf(followeeId));
    }

    static class User {
        int userId;
        Set<Integer> followingIds = new HashSet<>();
        List<Tweet> tweets = new LinkedList<>();

        public User(int userId) {
            this.userId = userId;
        }
    }

    static class Tweet {
        int tweetId;
        int ownerId;
        int time;

        public Tweet(int tweetId, int ownerId, int time) {
            this.tweetId = tweetId;
            this.ownerId = ownerId;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        final Twitter twitter = new Twitter();
        twitter.follow(1, 5);
        System.out.println("twitter.users.size() = " + twitter.users.size());
        System.out.println("twitter.users.keySet() = " + twitter.users.keySet());
    }
}
