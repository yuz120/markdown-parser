import static org.junit.Assert.*; //imports junit assert

import java.io.IOException;

import java.nio.file.Files;

import java.util.*;

import java.nio.file.Path;

import org.junit.*; //imports junit 


public class MarkdownParseTest{ //tester class for MarkdownParse.java
    @Test
    public void addition(){  //test addition in MarkdownParseTest
        assertEquals(2,1+1); //asserts 2 equals to 1+1
    }

    @Test
    public void getLinksTest()throws IOException{ //expect to return a list
       
          //  String content = testfile2.md.readString();
           //  testfile2.Path.of;
       
       
        // MarkdownParse.getLinks(content); //on the content (expect to return a list of strings)

        Path filePath = Path.of("test-file.md"); //test not found.
        String content=Files.readString(filePath);
        System.out.println(content);
        assertEquals("expects to return the file content",List.of("https://something.com","some-thing.html"), MarkdownParse.getLinks(content)); //[https://something.com,some-thing.html]
    }
    
}
