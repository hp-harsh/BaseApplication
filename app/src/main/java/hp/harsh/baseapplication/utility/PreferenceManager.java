package hp.harsh.baseapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Harsh Patel on 11/15/2016.
 */

public class PreferenceManager {

    private static String TAG = "PreferenceManager";

    public static PreferenceManager mPreferenceManager;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static PreferenceManager getInstance() {
        return mPreferenceManager;
    }

    public PreferenceManager(Context context) {
        mPreferenceManager = this;
        mSharedPreferences = context.getSharedPreferences(VariableBag.SHAREDPREFRENCE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    // Require to save location data
    public void logoutUser() {
        mEditor.putString(VariableBag.USER_ID, "").commit();
        mEditor.putString(VariableBag.ACCESS_TOKEN, "").commit();
    }

    // Require to save login data
    public void saveLoginData(String userId, String name, String email, String contact, String villageName, String houseNr, String accessToken) {
        mEditor.putString(VariableBag.USER_ID, "" + userId);
        mEditor.putString(VariableBag.USER_NAME, "" + name);
        mEditor.putString(VariableBag.USER_EMAIL, "" + email);
        mEditor.putString(VariableBag.USER_CONTACT, "" + contact);
        mEditor.putString(VariableBag.USER_VILLAGE_NAME, "" + villageName);
        mEditor.putString(VariableBag.USER_HOUSE_NR, "" + houseNr);
        mEditor.putString(VariableBag.ACCESS_TOKEN, "" + accessToken);
        mEditor.commit();
    }

    // Require to save latitude data
    public void saveUserLatitude(String latitude) {
        mEditor.putString(VariableBag.USER_LATITUDE, "" + latitude).commit();
    }

    // Require to save longitude data
    public void saveUserLongitude(String longitude) {
        mEditor.putString(VariableBag.USER_LONGITUDE, "" + longitude).commit();
    }

    // Require to save location data
    public void saveUserLocation(String location) {
        mEditor.putString(VariableBag.USER_LOCATION, "" + location).commit();
    }

    // Require to save location data
    public void saveDepartmentData(String departments) {
        mEditor.putString(VariableBag.DEPARTMENT_DATA_STRING, "" + departments).commit();
    }

    // Require to get access token
    public String getAccessToken() {
        return mSharedPreferences.getString(VariableBag.ACCESS_TOKEN, "");
    }

    // Require to get device token
    public String getDeviceToken() {
        return mSharedPreferences.getString(VariableBag.DEVICE_TOKEN, "");
    }

    // Require to get user email
    public String getUserId() {
        return mSharedPreferences.getString(VariableBag.USER_ID, "");
    }

    // Require to get user email
    public String getUserName() {
        return mSharedPreferences.getString(VariableBag.USER_NAME, "");
    }

    // Require to get user email
    public String getUserContact() {
        return mSharedPreferences.getString(VariableBag.USER_CONTACT, "");
    }

    // Require to get user email
    public String getUserEmail() {
        return mSharedPreferences.getString(VariableBag.USER_EMAIL, "");
    }

    // Require to get password
    public String getUserPassword() {
        return mSharedPreferences.getString(VariableBag.USER_PASSWORD, "");
    }

    // Require to save location data
    public String getDepartmentData() {
        return mSharedPreferences.getString(VariableBag.DEPARTMENT_DATA_STRING, "");
    }
}
