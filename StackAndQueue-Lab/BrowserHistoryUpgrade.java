package StackAndQueue;

        import java.util.ArrayDeque;
        import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {

            if (command.equals("back")) {
                if (urls.size() > 1) {
                    String tempUrl =  urls.pop();
                    System.out.println(urls.peek());
                    forwardUrls.push(tempUrl);
                }else {
                    System.out.println("no previous URLs");
                }
            }else if (command.equals("forward")){
                if (!forwardUrls.isEmpty()){
                    String url = forwardUrls.pop();
                    System.out.println(url);
                    urls.push(url);
                }else {
                    System.out.println("no next URLs");
                }
            }else {
                forwardUrls.clear();
                urls.push(command);
                System.out.println(command);
            }
            command = scanner.nextLine();
        }
    }
}
