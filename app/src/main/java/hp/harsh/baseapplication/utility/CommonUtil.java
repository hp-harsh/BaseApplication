package hp.harsh.baseapplication.utility;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hp.harsh.baseapplication.R;
import hp.harsh.baseapplication.custom.CircularImageView;
import hp.harsh.baseapplication.custom.SquareImageView;

/**
 * Created by Harsh on 2/6/2016.
 */
public class CommonUtil {

    /* Includes :
      getIMEI
      getOSversion
      getDeviceName
      getOSname
      getAppVersion
      getPackagename
      getFacebookSHA
      setBlurView
      getLanguage
      getCurrentTime
      getCurrentDate
      getDateConversation
      getMilliSeconds
      getMilliSecondsFromCurrentDate
      convertServerToDeviceTimezone
      dpTopx
      pxToDp
      getLocation
      getURLFromParams (For volly library get method)
      checkEmail
      checkPassword
      isValidUrl
      isValidNumeric
      isNullString
      stringToInt
      stringToFloat
      stringToDouble
      cmToInch
      inchToCm
      getTwoDigitTime
      isInternetAvailable
      convertListToArray
      convertArrayToList
      checkGPS
      showGPSDisabledAlertToUser
      showSoftKeyboard
      hideSoftKeyboard
      getAgeFromBirthDay
      get_Picture_bitmap
      getFileSize
      getUTFEncodedString
      setImageToGlide
      setSquareImageToGlide
      setCircularImageToGlide
      getFullDate
      imageToBase64
      getExternalStorageAvailable*/

    public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");
    public final static Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public final static Pattern PASSWORD_VALIDATION = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z*\\d]).{6,20})");
    public final static Pattern WEB_URL_PATTERN = Patterns.WEB_URL;
    public final static Pattern NUMERIC_PATTERN = Pattern.compile("^[-+]?[0-9]*\\.?[0-9]+$");

    public static void setStar(ImageView imgStar1, ImageView imgStar2, ImageView imgStar3, ImageView imgStar4, ImageView imgStar5, ImageView imgStar6, String rating) {

        float ratingstar = Float.parseFloat("" + rating);

        int rattingValue = (int) Math.ceil(ratingstar);

        imgStar1.setVisibility(View.GONE);
        imgStar2.setVisibility(View.GONE);
        imgStar3.setVisibility(View.GONE);
        imgStar4.setVisibility(View.GONE);
        imgStar5.setVisibility(View.GONE);
        imgStar6.setVisibility(View.GONE);

        if (rattingValue == 0.0) {

        } else if (rattingValue == 1.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.GONE);
            imgStar3.setVisibility(View.GONE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.GONE);
        } else if (rattingValue == 2.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.GONE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.GONE);
        } else if (rattingValue == 3.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.VISIBLE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.GONE);
        } else if (rattingValue == 4.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.VISIBLE);
            imgStar4.setVisibility(View.VISIBLE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.GONE);
        } else if (rattingValue == 5.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.VISIBLE);
            imgStar4.setVisibility(View.VISIBLE);
            imgStar5.setVisibility(View.VISIBLE);
            imgStar6.setVisibility(View.GONE);
        } else if (rattingValue > 0.0 && rattingValue < 1.0) {
            imgStar1.setVisibility(View.GONE);
            imgStar2.setVisibility(View.GONE);
            imgStar3.setVisibility(View.GONE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.VISIBLE);
        } else if (rattingValue > 1.0 && rattingValue < 2.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.GONE);
            imgStar3.setVisibility(View.GONE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.VISIBLE);
        } else if (rattingValue > 2.0 && rattingValue < 3.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.GONE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.VISIBLE);
        } else if (rattingValue > 3.0 && rattingValue < 4.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.VISIBLE);
            imgStar4.setVisibility(View.GONE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.VISIBLE);
        } else if (rattingValue > 4.0 && rattingValue < 5.0) {
            imgStar1.setVisibility(View.VISIBLE);
            imgStar2.setVisibility(View.VISIBLE);
            imgStar3.setVisibility(View.VISIBLE);
            imgStar4.setVisibility(View.VISIBLE);
            imgStar5.setVisibility(View.GONE);
            imgStar6.setVisibility(View.VISIBLE);
        }
    }

    public String getIMEI(Context context) {
        TelephonyManager mngr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return mngr.getDeviceId().toString();
    }

    public static String getOSversion() {
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public String getOSname() {
        StringBuilder builder = new StringBuilder();
        builder.append("");

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                builder.append(fieldName);
                Log.i("osName", "" + builder.toString());
                //builder.append(" : ").append(fieldName).append(" : ");
                //builder.append("sdk=").append(fieldValue);
            }
        }
        return builder.toString();
    }

    public static String getAppVersion(Context context) {
        PackageInfo pInfo = null;
        String version = "";
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = pInfo.versionName;
            Log.i("version", "" + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public static String getPackagename(Context context) {
        return context.getPackageName();
    }

    public static void getFacebookSHA(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "hp.harsh.baseapplication", PackageManager.GET_SIGNATURES); //Your package name here
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static void setBlurView(final Context context, final View backgroundView, final View toBeBlurView) {
        //final View content = getActivity().findViewById(android.R.id.content).getRootView();
        if (backgroundView.getWidth() > 0) {
            Bitmap image = BlurBuilder.blur(backgroundView);
            toBeBlurView.setBackgroundDrawable(new BitmapDrawable(context.getResources(), image));
        } else {
            backgroundView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    Bitmap image = BlurBuilder.blur(backgroundView);
                    toBeBlurView.setBackgroundDrawable(new BitmapDrawable(context.getResources(), image));
                }
            });
        }
    }

    public static String getLanguage() {
        String lang = Locale.getDefault().getLanguage();
        if (lang.equalsIgnoreCase("fr")) {
            lang = "fr";
        } else {
            lang = "en";
        }
        return lang;
    }

    private String getCurrentTime() {
        NumberFormat f = new DecimalFormat("00");

        String curTime = "";
        Calendar cal = Calendar.getInstance();
        int thisHour = cal.get(Calendar.HOUR);
        int thisMinut = cal.get(Calendar.MINUTE);
        int thisAMPM = cal.get(Calendar.AM_PM);
        if (thisAMPM == 0) {
            curTime = f.format(thisHour) + ":" + f.format(thisMinut) + " AM";
        } else {
            curTime = f.format(thisHour) + ":" + f.format(thisMinut) + " PM";
        }
        return curTime;
    }

    public static String getCurrentDate() {
        NumberFormat f = new DecimalFormat("00");

        String curDate = "";
        Calendar cal = Calendar.getInstance();

        int thisDate = cal.get(Calendar.DAY_OF_MONTH);
        int thisMonth = cal.get(Calendar.MONTH) + 1;
        int thisYear = cal.get(Calendar.YEAR);

        return curDate = f.format(thisYear) + "/" + f.format(thisMonth) + "/" + f.format(thisDate);
    }

    public static String getCurrentDateInPreferredFormat(SimpleDateFormat simpleDateFormat) {
        Calendar c = Calendar.getInstance();

        return simpleDateFormat.format(c.getTime());
    }

    public static String getDateConversation(String date, DateFormat originalFormat, DateFormat targetFormat) {
        String formattedDate = "";
        try {
            Date d = originalFormat.parse(date);
            formattedDate = targetFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static String getYesterday(String date, DateFormat originalFormat, DateFormat targetFormat) {
        String formattedDate = "";
        try {
            Date d = originalFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.DAY_OF_YEAR, -1);
            Date newDate = cal.getTime();
            formattedDate = targetFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static long getMilliSeconds(String dateFormate, String date) {

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormate, Locale.ENGLISH);
        formatter.setLenient(false);
        Date oldDate = null;
        try {
            oldDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return oldDate.getTime();
    }

    public static long getMilliSecondsFromCurrentDate(String currentDateFormate, String futureDateFormate, String current, String date) {
        Date futureDate = null;
        Date currentDate = null;

        Log.i("current", "" + current);
        Log.i("date", "" + date);
        try {
            futureDate = new SimpleDateFormat(futureDateFormate, Locale.ENGLISH).parse(date);
            currentDate = new SimpleDateFormat(currentDateFormate, Locale.ENGLISH).parse(current);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millisecondsForFuture = futureDate.getTime();
        long millisecondsForCurrent = currentDate.getTime();
        long millisecondsFromNow = millisecondsForFuture - millisecondsForCurrent - 7200000;
        return millisecondsFromNow;
    }

    public static String convertServerToDeviceTimezone(String serverTimezone, String serverDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("" + serverTimezone));
        Date timezonedate = null;
        try {
            timezonedate = simpleDateFormat.parse("" + serverDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //TimeZone destTz = TimeZone.getTimeZone("yourtimezone");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String result = simpleDateFormat.format(timezonedate);
        Log.i("result", "" + result);

        return result;
    }

    public static String getMilliSecondsBeforeNumberOfHours(String futureDateFormate, String date, String numberOfHour) {
        Date futureDate = null;
        String result = "";

        int hoursToSubstract = stringToInt("" + numberOfHour);

        Log.i("date", "" + date);
        try {
            futureDate = new SimpleDateFormat(futureDateFormate).parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(futureDate);
            result = String.format("%02d:%02d", (cal.get(Calendar.HOUR_OF_DAY) - hoursToSubstract), cal.get(Calendar.MINUTE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean getMilliSecondsAfterTwoHours(String currentDateFormate, String futureDateFormate, String current, String date) {
        Date futureDate = null;
        Date currentDate = null;
        boolean result = false;

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        /*Log.i("current", "" + current);
        Log.i("date", "" + date);*/
        try {
            currentDate = new SimpleDateFormat(currentDateFormate).parse(current);
            futureDate = new SimpleDateFormat(futureDateFormate).parse(date);

            Calendar currentCal = Calendar.getInstance();
            currentCal.setTime(currentDate);
            currentCal.add(Calendar.HOUR_OF_DAY, 3);
            String result1 = currentCal.get(Calendar.YEAR) + "-" + String.format("%02d", (currentCal.get(Calendar.MONTH) + 1)) + "-" + String.format("%02d", currentCal.get(Calendar.DAY_OF_MONTH)) + " " + String.format("%02d:%02d", currentCal.get(Calendar.HOUR_OF_DAY), currentCal.get(Calendar.MINUTE));

            Calendar futureCal = Calendar.getInstance();
            futureCal.setTime(futureDate);
            String result2 = futureCal.get(Calendar.YEAR) + "-" + String.format("%02d", (futureCal.get(Calendar.MONTH) + 1)) + "-" + String.format("%02d", futureCal.get(Calendar.DAY_OF_MONTH)) + " " + String.format("%02d:%02d", futureCal.get(Calendar.HOUR_OF_DAY), futureCal.get(Calendar.MINUTE));

            //Log.i("currentCal Date", "" + currentCal.get(Calendar.HOUR_OF_DAY));
            //Log.i("currentCal Date", "" + currentCal.get(Calendar.AM_PM + Calendar.HOUR));
            Log.i("currentCal Date", "" + result1);
            Log.i("futureCal Date", "" + result2);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            Date date1 = dateFormat.parse(result1);
            Date date2 = dateFormat.parse(result2);

            if (date2.after(date1)) {
                Log.i("CompareDate", "false");
                result = false;
            } else {
                Log.i("CompareDate", "true");
                result = true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static String getLocation(Context context, String latitude, String longitude) {
        String location = "";
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(Double.parseDouble(latitude), Double.parseDouble(longitude), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            location = "" + address + ", " + state + ", " + country + ", " + postalCode;
            location = location.replace(", null", "");
            location = location.replace("null", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return location;
    }

    public static String getDateFormatedTime(String time, String iHaveFormat, String iWantFormat) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(iHaveFormat);
            Date date = (Date) formatter.parse(time);
            SimpleDateFormat newFormat = new SimpleDateFormat(iWantFormat);
            String finalString = newFormat.format(date);
            return finalString;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getURLFromParams(String url, Map<String, String> params) {
        Iterator entries = params.entrySet().iterator();
        int i = 0;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (i == 0) {
                url = url + key + "=" + value;
            } else {
                url = url + "&" + key + "=" + value;
            }
            i++;
        }
        return url;
    }

    public static boolean checkEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean checkPassword(String password) {
        return PASSWORD_VALIDATION.matcher(password).matches();
    }

    public static boolean isValidUrl(String url) {
        Matcher m = WEB_URL_PATTERN.matcher(url);
        if (m.matches())
            return true;
        else
            return false;
    }

    public static boolean isValidNumeric(String number) {
        boolean isValid = false;
        CharSequence inputStr = number;
        Matcher matcher = NUMERIC_PATTERN.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isNullString(String string) {
        try {
            if (string.trim().equalsIgnoreCase("null") || string.trim() == null || string.trim().length() < 0 || string.trim().equals("")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public static int stringToInt(String str) {
        Log.i("str", "" + str);
        String regexStr = "^[0-9]*$";
        if (str.matches(regexStr)) {
        } else {
            float value = stringToFloat(str);
            Log.i("value", "" + value);
            str = "" + (int) Math.round(value);
        }
        return Integer.parseInt(str);
    }

    public static float stringToFloat(String str) {
        return Float.parseFloat(str);
    }

    public static double stringToDouble(String str) {
        return Double.parseDouble(str);
    }

    public static String cmToInch(String value) {
        DecimalFormat df = new DecimalFormat("#.####");

        String regexStr = "^[0-9]*$";

        if (value.matches(regexStr)) {
            int mMin = CommonUtil.stringToInt(value);

            double mMinIn = mMin / 2.54;

            return df.format(mMinIn);
        } else if (!isNullString(value)) {
            double mMin = CommonUtil.stringToDouble(value);

            double mMinIn = mMin / 2.54;

            return df.format(mMinIn);
        } else {
            return value;
        }
    }

    public static String inchToCm(String value) {
        double temp = CommonUtil.stringToDouble(value) * 2.54;
        Double d = new Double(temp);
        return "" + d.intValue();
    }

    public static String stringToIntForHeight(String value) {
        Double d = new Double(CommonUtil.stringToDouble(value));
        return "" + d.intValue();
    }

    public static String getTwoDigitTime(int string) {
        try {
            if (String.valueOf(string).length() == 1) {
                return "0" + string;
            } else {
                return "" + string;
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isInternetAvailable(Context context) {
        ConnectionDetector cd = new ConnectionDetector(context);
        Boolean isInternetPresent = cd.isConnectingToInternet();

        if (!isInternetPresent) {
            ToastUtil.show(context, context.getResources().getString(R.string.toast_no_internet));
            return false;
        } else {
            return isInternetPresent;
        }
    }

    public static String[] convertListToArry(ArrayList<String> data) {
        String[] array = new String[data.size()];
        return array = data.toArray(array);
    }

    public static ArrayList<String> convertAarryToList(String[] arry) {
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < arry.length; i++) {
            data.add(arry[i]);
        }
        return data;
    }

    public static boolean checkPlayServices(Activity activity) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, activity,
                        9000).show();
            } else {
                Log.e("checkPlayServices", "This device is not supported.");
                activity.finish();
            }
            return false;
        }
        return true;
    }

    public static boolean checkGPS(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return true;
            //Toast.makeText(getActivity(), "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();
        } else {
            showGPSDisabledAlertToUser(context);
            return false;
        }
    }

    public static void showGPSDisabledAlertToUser(final Context context) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        //builder.setTitle("");
        builder.setMessage("" + context.getResources().getString(R.string.gps_message));
        builder.setPositiveButton(context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int flag) {
                Intent callGPSSettingIntent = new Intent(
                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(callGPSSettingIntent);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int flag) {
                dialogInterface.dismiss();
            }
        });

        android.support.v7.app.AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    public static void showSoftKeyboard(Context context) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideSoftKeyboard(Context context) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getAgeFromBirthDay(String birthDate) {
        int y, m, d, age = 0;
        try {
            Calendar calBirth = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            calBirth.setTime(sdf.parse("" + birthDate));

            GregorianCalendar cal = new GregorianCalendar();
            y = cal.get(Calendar.YEAR);
            m = cal.get(Calendar.MONTH);
            d = cal.get(Calendar.DAY_OF_MONTH);
            cal.set(calBirth.get(Calendar.YEAR), (calBirth.get(Calendar.MONTH) + 1), calBirth.get(Calendar.DAY_OF_MONTH));
            age = y - cal.get(Calendar.YEAR);
            if ((m < cal.get(Calendar.MONTH))
                    || ((m == cal.get(Calendar.MONTH)) && (d < cal
                    .get(Calendar.DAY_OF_MONTH)))) {
                --age;
            }
            /*if (age < 0)
                throw new IllegalArgumentException("Age < 0");*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return age;
    }

    public static File get_Picture_bitmap(String imagePath) {

        File imageFile = new File(imagePath);

        long size_file = getFileSize(imageFile);

        LogUtil.i("CommonUtil", "Initial image size : " + size_file);

        size_file = (size_file) / 1000;// in Kb now
        int ample_size = 1;

        if (size_file <= 250) {

            LogUtil.i("CommonUtil", "SSSSS1111= " + size_file);
            ample_size = 2;

        } else if (size_file > 251 && size_file < 1500) {

            LogUtil.i("CommonUtil", "SSSSS2222= " + size_file);
            ample_size = 4;

        } else if (size_file >= 1500 && size_file < 3000) {

            LogUtil.i("CommonUtil", "SSSSS3333= " + size_file);
            ample_size = 8;

        } else if (size_file >= 3000 && size_file <= 4500) {

            LogUtil.i("CommonUtil", "SSSSS4444= " + size_file);
            ample_size = 12;

        } else if (size_file >= 4500) {

            LogUtil.i("CommonUtil", "SSSSS5555= " + size_file);
            ample_size = 16;
        } else {
            LogUtil.i("CommonUtil", "SSSSS6666= " + size_file);
        }

        Bitmap bitmap = null;

        BitmapFactory.Options bitoption = new BitmapFactory.Options();
        bitoption.inSampleSize = ample_size;

        Bitmap bitmapPhoto = BitmapFactory.decodeFile(imagePath, bitoption);

        ExifInterface exif = null;
        try {
            exif = new ExifInterface(imagePath);
        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        int orientation = exif
                .getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        Matrix matrix = new Matrix();

        if ((orientation == 3)) {
            matrix.postRotate(180);
            bitmap = Bitmap.createBitmap(bitmapPhoto, 0, 0,
                    bitmapPhoto.getWidth(), bitmapPhoto.getHeight(), matrix,
                    true);

        } else if (orientation == 6) {
            matrix.postRotate(90);
            bitmap = Bitmap.createBitmap(bitmapPhoto, 0, 0,
                    bitmapPhoto.getWidth(), bitmapPhoto.getHeight(), matrix,
                    true);

        } else if (orientation == 8) {
            matrix.postRotate(270);
            bitmap = Bitmap.createBitmap(bitmapPhoto, 0, 0,
                    bitmapPhoto.getWidth(), bitmapPhoto.getHeight(), matrix,
                    true);

        } else {
            matrix.postRotate(0);
            bitmap = Bitmap.createBitmap(bitmapPhoto, 0, 0,
                    bitmapPhoto.getWidth(), bitmapPhoto.getHeight(), matrix,
                    true);

        }

        try {
            imageFile.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(imageFile);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogUtil.i("CommonUtil", "Final image size : " + getFileSize(imageFile));

        return imageFile;
    }


    public static long getFileSize(final File file) {
        if (file == null || !file.exists())
            return 0;
        if (!file.isDirectory())
            return file.length();
        final List<File> dirs = new LinkedList<File>();
        dirs.add(file);
        long result = 0;
        while (!dirs.isEmpty()) {
            final File dir = dirs.remove(0);
            if (!dir.exists())
                continue;
            final File[] listFiles = dir.listFiles();
            if (listFiles == null || listFiles.length == 0)
                continue;
            for (final File child : listFiles) {
                result += child.length();
                if (child.isDirectory())
                    dirs.add(child);
            }
        }

        return result;
    }

    public static String getUTFEncodedString(String data) {
        byte ptext[] = data.getBytes();
        String value = null;
        try {
            value = new String(ptext, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void setImageToGlide(final Context context, final ImageView imageView, String imageUrl) {
        Glide.with(context).load("" + imageUrl).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                //holder.imgRestaurant.setImageResource();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).placeholder(R.drawable.girl_place_holder).into(imageView);
    }

    public static void setSquareImageToGlide(final Context context, final SquareImageView imageView, String imageUrl) {
        Glide.with(context).load("" + imageUrl).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                //holder.imgRestaurant.setImageResource();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).placeholder(R.drawable.girl_place_holder).into(imageView);
    }

    public static void setCircularImageToGlide(final Context context, final CircularImageView imageView, String imageUrl) {
        Glide.with(context).load("" + imageUrl).asBitmap().into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    public static String getFullDate(String originaldate) {
        try {

            DateFormat inputFormatter1 = new SimpleDateFormat("yyyy-MM-dd");    //2016-05-24
            Date date1 = inputFormatter1.parse(originaldate);

            DateFormat outputFormatter1 = new SimpleDateFormat("cccc, MMMM dd");    //Wednesday, February 12
            String output1 = outputFormatter1.format(date1);

            return output1;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String imageToBase64(File fileName) {
        String encodedString = "";
        try {
            InputStream inputStream = new FileInputStream(fileName);//You can get an inputStream using any IO API
            byte[] bytes;
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            try {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes = output.toByteArray();
            encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);
            Log.i("imageToBase64", "Encoded String:" + encodedString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return encodedString;
    }

    public static long getExternalStorageAvailable() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = (long) stat.getBlockSize() * (long) stat.getAvailableBlocks();
        long megAvailable = bytesAvailable / (1024 * 1024);
        Log.e("CommonUtil", "Available MB : " + megAvailable);
        return megAvailable;
    }
}
