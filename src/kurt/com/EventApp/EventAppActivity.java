package kurt.com.EventApp;

import android.app.Activity;
import android.os.Bundle;
import java.io.InputStream;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import android.util.Log;

public class EventAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        //testing git
        //another test of clone and push
        
        getInputStreamFromUrl("http://0.0.0.0:3000/events.json");
        
        Log.v("blah", "blah blah");
    }
    
    public static InputStream getInputStreamFromUrl(String url) {
	  InputStream content = null;
	  try {
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpResponse response = httpclient.execute(new HttpGet(url));
	    content = response.getEntity().getContent();
	  } catch (Exception e) {
	    Log.v("[GET REQUEST]", "Network exception", e);
	  }
	    return content;
	}
   	// see http://androidsnippets.com/executing-a-http-get-request-with-httpclient
}