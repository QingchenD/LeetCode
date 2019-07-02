import java.lang.reflect.Array;
import java.util.*;

/**
 * 355. 设计推特
 * https://leetcode-cn.com/problems/design-twitter/
 *
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 */


public class Twitter {

    /**
     * 执行用时 :147 ms, 在所有 Java 提交中击败了87.70%的用户
     * 内存消耗 :54.4 MB, 在所有 Java 提交中击败了70.00%的用户
     */

    private HashMap<Integer, HashSet<Integer>> follows;
    private HashMap<Integer, List<Message>> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Message msg = new Message(tweetId);
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(msg);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Message> arrayList = new ArrayList<>();
        List<Message> self = tweets.get(userId);
        if (self != null) {
            for (int i = 0; i < 10 && self.size() > i; i++) {
                arrayList.add(self.get(self.size() - 1 - i));
            }
        }

        Set<Integer> follow = follows.get(userId);
        if (follow != null) {
            for (Integer id : follow) {
                List<Message> msgs = tweets.get(id);
                if (msgs != null) {
                    for (int i = 0; i < 10 && msgs.size() > i; i++) {
                        arrayList.add(msgs.get(msgs.size() - 1 - i));
                    }
                }
            }
        }

        Message[] msg = arrayList.toArray(new Message[0]);
        Arrays.sort(msg,new Comparator<Message>(){
            @Override
            public int compare(Message o1, Message o2) {
                long l = o2.time - o1.time;
                return l > 0 ? 1 : (l == 0 ? 0 : -1) ;
            }
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10 && msg.length > i; i++) {
            result.add(msg[i].id);
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.computeIfAbsent(followerId, K -> new LinkedHashSet<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> f = follows.get(followerId);
        if (f != null) {
            f.remove(followeeId);
        }
    }

    class Message {
        int id;
        long time;
        Message(int id) {
            this.id = id;
            this.time = System.nanoTime();
        }
    }
}
