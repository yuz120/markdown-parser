//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int numOpenBracket=0;
        int numCloseBracket=0;
        int numOpenParen=0;
        int numCloseParen=0;
        System.out.println("initial currentIndex is " +currentIndex);
        while(currentIndex < markdown.length()) { 
            int openBracket = markdown.indexOf("[", currentIndex);
            numOpenBracket++;
            int closeBracket = markdown.indexOf("]", openBracket);
            numOpenBracket++;
            int openParen = markdown.indexOf("(", closeBracket);
            numOpenParen++;
            int closeParen = markdown.indexOf(")", openParen);
            numCloseParen++;
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            
            if(numCloseBracket!=numOpenBracket || numCloseParen!=numOpenParen){
                break;
            }

            currentIndex = closeParen+1;
            System.out.println("After incrementing  currentIndex is " +currentIndex);
            
        
            
           
        }
        System.out.println("After while loop, the currentIndex is " +currentIndex);

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
