import java.util.Stack;

public class DesignBrowserHistory {
    public static void main(String[] args){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
    static class BrowserHistory {
        private Stack<String> backward;
        private Stack<String> forward;
        String current;

        public BrowserHistory(String homepage) {
            current= homepage;
            backward = new Stack<String>();
            forward = new Stack<String>();
        }

        public void visit(String url) {
            //clears up all the forward history
            backward.push(current);
            current = url;
            forward.clear();
        }

        public String back(int steps) {
            while(!backward.empty() && steps > 0){
                forward.push(current);
                current =  backward.pop();
                steps--;
            }
            return current;
        }

        public String forward(int steps) {

            while(!forward.empty() && steps > 0){
                backward.push(current);
                current =  forward.pop();
                steps--;
            }
            return current;
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */


}
