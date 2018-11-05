package hp.harsh.baseapplication.network;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import hp.harsh.baseapplication.utility.CommonUtil;
import hp.harsh.baseapplication.utility.LogUtil;
import hp.harsh.baseapplication.utility.PreferenceManager;

/**
 * Created by Harsh on 2/10/2016.
 */
public class RequestParam {

    private static String TAG = "RequestParam";

    public static Map<String, String> getNull() {
        Map<String, String> mParam = new HashMap<String, String>();
        return mParam;
    }

    public static Map<String, String> loginHeader(Context c, String deviceToken) {
        Map<String, String> map = new HashMap<>();
        LogUtil.i(TAG, "deviceToken:" + deviceToken);
        map.put("os", "android");
        map.put("lang", "EN");
        map.put("device", "" + CommonUtil.getDeviceName());
        map.put("appv", "" + CommonUtil.getAppVersion(c));
        map.put("osv", "" + CommonUtil.getOSversion());
        map.put("devicetoken", "" + deviceToken);
        return map;
    }

    public static Map<String, String> forgotPasswordHeader(Context c) {
        Map<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("lang", "EN");
        map.put("device", "" + CommonUtil.getDeviceName());
        map.put("appv", "" + CommonUtil.getAppVersion(c));
        map.put("osv", "" + CommonUtil.getOSversion());
        return map;
    }

    public static Map<String, String> defaultHeader(Context c) {
        Map<String, String> map = new HashMap<>();
        LogUtil.i(TAG, "accesstoken:" + PreferenceManager.getInstance().getAccessToken());
        LogUtil.i(TAG, "uid:" + PreferenceManager.getInstance().getUserId());
        map.put("os", "android");
        map.put("lang", "EN");
        map.put("device", "" + CommonUtil.getDeviceName());
        map.put("appv", "" + CommonUtil.getAppVersion(c));
        map.put("osv", "" + CommonUtil.getOSversion());
        map.put("accesstoken", "" + PreferenceManager.getInstance().getAccessToken());
        map.put("uid", "" + PreferenceManager.getInstance().getUserId());
        return map;
    }

    public static Map<String, String> checkLogin(String email, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        return map;
    }

    public static Map<String, String> registerUser(String first_name, String email, String contact, String villageName, String houseNr, String password, String passwordConfirm) {
        Map<String, String> map = new HashMap<>();
        map.put("first_name", first_name);
        map.put("email", "" + email);
        map.put("phone", contact);
        map.put("village", villageName);
        map.put("house_nr", houseNr);
        map.put("password", "" + password);
        map.put("passconf", "" + passwordConfirm);
        return map;
    }

    public static Map<String, String> forgotPassword(String email) {
        File file = new File("");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(file);
        jsonArray.put(file);
        jsonArray.put(file);
        jsonArray.put(file);
        jsonArray.put(file);

        Map<String, String> map = new HashMap<>();
        map.put("email", "" + email);
        return map;
    }

    public static Map<String, String> resetPassword(String email, String password, String passwordConfirm) {
        Map<String, String> map = new HashMap<>();
        Log.i("email", "" + email);
        map.put("email", "" + email);
        map.put("password", "" + password);
        map.put("passnew", "" + passwordConfirm);
        return map;
    }

    public static Map<String, String> newMaintenance(String title, String description, String departmentId, String lat, String lng, String location, String name, String email, String phone) {
        File file = new File("");
        Map<String, String> map = new HashMap<>();
        Log.i("title", "" + title);
        Log.i("description", "" + description);
        Log.i("departmentId", "" + departmentId);
        map.put("title", "" + title);
        map.put("description", "" + description);
        map.put("did", "" + departmentId);
        map.put("lat", "" + lat);
        map.put("lng", "" + lng);
        map.put("location", "" + location);
        map.put("name", "" + name);
        map.put("phone", "" + phone);
        map.put("email", "" + email);
        return map;
    }
}
