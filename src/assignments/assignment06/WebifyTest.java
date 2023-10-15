package assignments.assignment06;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WebifyTest {
    @Test
    public void testUrl(){
        assertEquals("<a href=\"http://www.google.com\">Google</a>", Webify.checkHyperLink("[[http://www.google.com][Google]]"));
        assertEquals("[http://www.google.com][Google]", Webify.checkHyperLink("[http://www.google.com][Google]"));
        assertEquals("<a href=\"http://www.youtube.com\">Youtube</a>", Webify.checkHyperLink("[[http://www.youtube.com][Youtube]]"));
    }
}
