package hp.harsh.baseapplication.utility;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import hp.harsh.baseapplication.R;
import hp.harsh.baseapplication.activity.MainActivity;

/**
 * Created by Harsh Patel on 7/30/2016.
 */
public class NotificationManager {

    private static String TAG = "NotificationManager";

    public static NotificationManager mInstance = new NotificationManager();
    private static android.app.NotificationManager mNotificationManager;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public NotificationManager() {
    }

    public static NotificationManager getInstance() {
        return mInstance;
    }

    public void generateIndividualNotification(Context context, String message) {
        Log.i(TAG, "Notification : true");

        if (context == null)
            return;

        mSharedPreferences = context.getSharedPreferences(VariableBag.SHAREDPREFRENCE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        if (mSharedPreferences.getString(VariableBag.USER_ID, "").equals("")) {
            return;
        }

        if (mSharedPreferences.contains(VariableBag.NOTIFICATION_COUNTER)) {
            int tripCounter = mSharedPreferences.getInt(VariableBag.NOTIFICATION_COUNTER, 200);
            tripCounter++;
            mEditor.putInt(VariableBag.NOTIFICATION_COUNTER, tripCounter).commit();
        } else {
            mEditor.putInt(VariableBag.NOTIFICATION_COUNTER, 200).commit();
        }

        Log.i(TAG, "NOTIFICATION_COUNTER : " + mSharedPreferences.getInt(VariableBag.NOTIFICATION_COUNTER, 200));

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            Bitmap icon1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);

            NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(
                    context).setAutoCancel(true)
                    .setContentTitle("VH IOA")
                    .setContentText(message)
                    .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon1)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(message));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Log.i(TAG, "Is this above LOLLIPOP : Yes");
                mBuilder.setPriority(Notification.PRIORITY_HIGH);
                mBuilder.setAutoCancel(true);
            }

            /*android.support.v7.app.NotificationCompat.InboxStyle inboxStyle = new android.support.v7.app.NotificationCompat.InboxStyle();
            inboxStyle.setBigContentTitle("VH IOA");

            for (int i = 0; i < arrTripMessage.size(); i++) {

                if (arrTripMessage.size() == 1) {
                    mBuilder.setContentText("Dispatcher : " + arrTripMessage.get(i));
                    inboxStyle.addLine("Dispatcher : " + arrTripMessage.get(i));
                } else {
                    mBuilder.setContentText(arrTripMessage.size() + " trips is updated");
                    inboxStyle.addLine("Dispatcher : " + arrTripMessage.get(i));
                }
            }

            // Moves the big view style object into the notification object.
            mBuilder.setStyle(inboxStyle);*/

            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = null;

            resultIntent = new Intent(context, MainActivity.class);

            if (resultIntent == null) {
                return;
            }

            resultIntent.putExtra("from_view", "notification");
            android.app.TaskStackBuilder stackBuilder = android.app.TaskStackBuilder.create(context);

            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainActivity.class);

            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);

            Notification notification = mBuilder.build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notification.defaults |= Notification.DEFAULT_SOUND;
            notification.defaults |= Notification.DEFAULT_VIBRATE;

            android.app.NotificationManager mNotificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            // mId allows you to update the notification later on.
            mNotificationManager.notify(mSharedPreferences.getInt(VariableBag.NOTIFICATION_COUNTER, 200), notification);
        } else {
            android.support.v4.app.NotificationCompat.Builder mBuilder = new android.support.v4.app.NotificationCompat.Builder(context);

            mBuilder.setContentTitle("VH IOA");

            mBuilder.setSmallIcon(R.mipmap.ic_launcher);

            mBuilder.setContentText(message);

          	/* Increase notification number every time a new notification arrives */


          	/* Creates an explicit intent for an Activity in your app */
            Intent resultIntent = null;

            resultIntent = new Intent(context, MainActivity.class);

            if (resultIntent == null) {
                return;
            }

            resultIntent.putExtra("from_view", "notification");
            android.support.v4.app.TaskStackBuilder stackBuilder = android.support.v4.app.TaskStackBuilder.create(context);
            stackBuilder.addParentStack(MainActivity.class);

          	      /* Adds the Intent that starts the Activity to the top of the stack */
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

            mBuilder.setContentIntent(resultPendingIntent);
            Notification notification = mBuilder.getNotification();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notification.defaults |= Notification.DEFAULT_SOUND;
            notification.defaults |= Notification.DEFAULT_VIBRATE;
            mNotificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

          	      /* notificationID allows you to update the notification later on. */
            mNotificationManager.notify(mSharedPreferences.getInt(VariableBag.NOTIFICATION_COUNTER, 200), notification);

        }
    }

    public void removeAllIndividualNotification(Context context) {
        mSharedPreferences = context.getSharedPreferences(VariableBag.SHAREDPREFRENCE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        String ns = Context.NOTIFICATION_SERVICE;
        android.app.NotificationManager nMgr = (android.app.NotificationManager) context.getApplicationContext().getSystemService(ns);

        int tripCounter = 200;
        if (mSharedPreferences.contains(VariableBag.NOTIFICATION_COUNTER)) {
            tripCounter = mSharedPreferences.getInt(VariableBag.NOTIFICATION_COUNTER, 200);
        }

        for (int i = 200; i <= tripCounter; i++) {
            nMgr.cancel(i);
        }

        mEditor.putInt(VariableBag.NOTIFICATION_COUNTER, 200).commit();
    }
}
