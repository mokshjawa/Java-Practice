import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Crawl the web starting from https://morepablo.com/no_robots/crawler/start.html
 This means: find and follow any links on the page, then find and follow any
 links on _those_ pages, and so on, until you've visited them all. Return a
 list of page URLs of pages that mention cats. They can be in singular or
 plural (so "cat" or "cats") and may start a sentence ("Cats are the
 greatest…").
 */


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(crawl("/no_robots/crawler/start.html"));
    }

    public static List<String> crawl(String startingURL) {
        String hostName = "https://morepablo.com";
        String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
        String HTML_A_HREF_TAG_PATTERN =
                "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

        List<String> catURLs = new ArrayList<>();
        Queue<String> toVisit = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        toVisit.add(hostName + startingURL);
        visited.add(hostName + startingURL);

        while (!toVisit.isEmpty()) {
            String current = toVisit.poll();

            URL url;

            try {
                // get URL content
                url = new URL(current);
                URLConnection conn = url.openConnection();

                // open the stream and put it into BufferedReader
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String inputLine;
                String content = "";
                while ((inputLine = br.readLine()) != null) {
                    content += inputLine + '\n';
                }

                br.close();

                if (isContain(content.toLowerCase(), "cat") || isContain(content.toLowerCase(), "cats")) {
                    catURLs.add(current);
                }

                Pattern patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
                Pattern patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);

                Matcher matcherTag = patternTag.matcher(content);

                while (matcherTag.find()) {

                    String href = matcherTag.group(1); // href
                    String linkText = matcherTag.group(2); // link text

                    Matcher matcherLink = patternLink.matcher(href);

                    while (matcherLink.find()) {
                        String link = matcherLink.group(1); // link
                        String toAdd = hostName + link.substring(1, link.length() - 1);
                        if (!visited.contains(toAdd)) {
                            toVisit.add(toAdd);
                            visited.add(toAdd);
                            System.out.println(toAdd);
                        }
                    }

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return catURLs;
    }

    private static boolean isContain(String source, String subItem){
        String pattern = "\\b"+subItem+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(source);
        return m.find();
    }
}
