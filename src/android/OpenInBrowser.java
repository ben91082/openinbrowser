import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
 
public class OpenInBrowser extends CordovaPlugin {
 
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("openInBrowser")) {
            String url = args.getString(0);
            this.openExternal(url);
            return true;
        }
        return false;
    }

    /**
     * Display a new browser with the specified URL.
     *
     * @param url the url to load.
     * @return "" if ok, or error message.
     */
    public String openExternal(String url) {
        try {
            Intent intent = null;
            intent = new Intent(Intent.ACTION_VIEW);
            // Omitting the MIME type for file: URLs causes "No Activity found to handle Intent".
            // Adding the MIME type to http: URLs causes them to not be handled by the downloader.
            Uri uri = Uri.parse(url);
            intent.setData(uri);
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, cordova.getActivity().getPackageName());
            this.cordova.getActivity().startActivity(intent);
            return "";
        } catch (android.content.ActivityNotFoundException e) {
            Log.d("OpenInBrowser", "OpenInBrowser: Error loading url "+url+":"+ e.toString());
            return e.toString();
        }
    }
}