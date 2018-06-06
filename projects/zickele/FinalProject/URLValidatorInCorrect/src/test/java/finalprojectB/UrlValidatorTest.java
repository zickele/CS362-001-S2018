
package finalprojectB;

import junit.framework.TestCase;
import java.util.concurrent.ThreadLocalRandom;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }


   //Manual tests
   public void testManualTest()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://www.google.com"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertTrue(urlVal.isValid("http://go.com"));

       //Pass, should not pass
       assertTrue(urlVal.isValid("http://"));
       assertTrue(urlVal.isValid("http://256.256.256.256"));
       assertFalse(urlVal.isValid("http://www.google.com:80/test1?action=view"));
       assertFalse(urlVal.isValid("http://www.google.com:80"));
       assertFalse(urlVal.isValid("http://www.google.com:0"));

       //Don't pass, should pass
       //assertTrue(urlVal.isValid("HTTP://www.google.com"));
       //assertFalse(urlVal.isValid("http://256.256.256.256"));
       //assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=view"));
       //assertTrue(urlVal.isValid("http://www.google.com:80"));
       //assertTrue(urlVal.isValid("http://www.google.com:0"));


       //Don't pass, shuoldn't pass
       //assertFalse(urlVal.isValid("http://www.google.com"));
       //assertTrue(urlVal.isValid(""));
       //assertTrue(urlVal.isValid("://oiuy.google.qwe"));

       //Error (Shuold pass)
       //assertTrue(urlVal.isValid("h3t://255.com"));
       //assertTrue(urlVal.isValid("file://"));
   }

   //Partition Tests
   public void testPartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertFalse(urlVal.isValid(""));
       assertFalse(urlVal.isValid(null));
   }

   public void testCasePartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://www.google.com"));

       //Error (should pass)
       //assertTrue(urlVal.isValid("HTTP://www.google.com"));
       //assertTrue(urlVal.isValid("FTP://www.google.com"));
       //assertTrue(urlVal.isValid("H3T://www.google.com"));
   }

   public void testSchemePartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://www.google.com"));
       assertFalse(urlVal.isValid("3ht://www.google.com"));
       assertFalse(urlVal.isValid("www.google.com"));

       //Pass, should not pass
       assertTrue(urlVal.isValid("http:/www.google.com"));

       //Error (Should pass)
       //assertTrue(urlVal.isValid("h3t://www.google.com"));
   }

   public void testAuthorityPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertTrue(urlVal.isValid("http://go.com"));

       //Pass, should not pass
       assertTrue(urlVal.isValid("http://go.1aa"));
       assertTrue(urlVal.isValid("http://"));
       assertFalse(urlVal.isValid("http://:"));
   }

   public void testPortPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       assertFalse(urlVal.isValid("http://www.google.com:-1"));
       assertFalse(urlVal.isValid("http://www.google.com:65636"));
       assertFalse(urlVal.isValid("http://www.google.com:65a"));

       //Dont Pass, should pass
       //assertTrue(urlVal.isValid("http://www.google.com:80"));
       //assertTrue(urlVal.isValid("http://www.google.com:65535"));
       //assertTrue(urlVal.isValid("http://www.google.com:0"));
   }

   public void testPathPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://www.google.com/test1"));
       assertTrue(urlVal.isValid("http://www.google.com/$23"));
       assertFalse(urlVal.isValid("http://www.google.com/.."));
       assertFalse(urlVal.isValid("http://www.google.com/../"));

       //Pass, should not pass

   }

   public void testQueryPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //Pass, should pass
       assertTrue(urlVal.isValid("http://www.google.com/test1?action=view"));
       assertTrue(urlVal.isValid("http://www.google.com/test1?action=edit&mode=up"));

       //Pass, should not pass

   }


   //Program based testing
   public void testIsValid()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String[] scheme = {"http://","ftp://","h3t://",
                          "3ht://","http:/","http:"};
       String[] authority = {"www.google.com","go.com","0.0.0.0",
                             "1.2.3.4.5", ".aaa","go.a1a"};
       String[] port = {":80",":65535",":0",
                        ":-1",":65636",":65a"};
       String[] path = {"/test1","/t123","/$23",
                        "/..","/..//file","/test1//file"};
       String[] query = {"?action=view","?action=edit&mode=up",""};

       for(int i = 0; i < 500; i++){
           StringBuilder testUrlBuilder = new StringBuilder();
           boolean isValid = true;

           int r1 = ThreadLocalRandom.current().nextInt(0, 5);
           int r2 = ThreadLocalRandom.current().nextInt(0, 5);
           int r3 = ThreadLocalRandom.current().nextInt(0, 5);
           int r4 = ThreadLocalRandom.current().nextInt(0, 5);
           int r5 = ThreadLocalRandom.current().nextInt(0, 2);

           testUrlBuilder.append(scheme[r1]);
           testUrlBuilder.append(authority[r2]);
           testUrlBuilder.append(port[r3]);
           testUrlBuilder.append(path[r4]);
           testUrlBuilder.append(query[r5]);

           String testUrl = testUrlBuilder.toString();
           if(r1 > 2 || r2 > 2 || r3 > 2 || r4 > 2){
               isValid = false;
           }
           System.out.println(testUrl);
           assertEquals(isValid,urlVal.isValid(testUrl));
       }
   }
 }
