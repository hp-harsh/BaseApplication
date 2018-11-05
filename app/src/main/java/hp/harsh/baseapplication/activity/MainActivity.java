package hp.harsh.baseapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimationFactory;

import hp.harsh.baseapplication.R;
import hp.harsh.baseapplication.custom.FlipAnimator;
import hp.harsh.baseapplication.fragment.TestFragment;
import hp.harsh.baseapplication.network.ApiManager;
import hp.harsh.baseapplication.network.RequestCode;
import hp.harsh.baseapplication.network.RequestParam;
import hp.harsh.baseapplication.permissionutil.PermissionCode;
import hp.harsh.baseapplication.utility.FragmentUtil;
import hp.harsh.library.interfaces.LoopjInterface;
import hp.harsh.library.loopj.LoopjRequest;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    // Example for flip animation
    private void showPrice() {
        View priceBeforeView = findViewById(R.id.price_before_text);
        View priceAfterText = findViewById(R.id.price_after_text);
        View priceContainer = findViewById(R.id.price_container);
        FlipAnimator animator = new FlipAnimator(priceBeforeView, priceAfterText, priceContainer.getWidth()/2, priceContainer.getHeight()/2);
        animator.setDuration(800);
        animator.setRotationDirection(FlipAnimator.DIRECTION_Y);
        priceContainer.startAnimation(animator);
    }*/

    /*private void askForPermission() {

        if (PermissionManager.hasPermissions(getActivity(), Permissions.RECORD_PERMISSIONS)) {
            //locationPermissionGranted(true);
        } else {
            Log.i(TAG, "Asking for Runtime Permissions...");
            PermissionManager.requestPermissions(ThirdFragment.this, permissionListener,
                    "Gimme the permission!", Permissions.RECORD_PERMISSIONS);
        }
    }

    private boolean checkForPermission() {
        return PermissionManager.hasPermissions(getActivity(), Permissions.RECORD_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.onRequestPermissionsResult(ThirdFragment.this, permissionListener, requestCode, permissions, grantResults);
    }

    private final PermissionManager.PermissionListener permissionListener = new PermissionManager.PermissionListener() {
        @Override
        public void onPermissionsGranted(List<String> perms) {
            if (perms.size() == Permissions.RECORD_PERMISSIONS.length) {
                Log.i(TAG, "We have all required permission, moving on fetching location!");
                //locationPermissionGranted(false);
            } else {
                Log.i(TAG, "User denied some of required permissions! "
                        + "Even though we have following permissions now, "
                        + "task will still be aborted.\n" + getStringFromList(perms));
            }

            setPermissionOverlay(false);
        }

        @Override
        public void onPermissionsDenied(List<String> perms) {
            Log.i(TAG, "User denied required permissions!\n" + getStringFromList(perms));

            setPermissionOverlay(true);
        }

        @Override
        public void onPermissionRequestRejected() {
            Log.i(TAG, "User didn't even let us to ask for permission!");

            setPermissionOverlay(true);
        }

        @Override
        public void onPermissionNeverAsked(List<String> perms) {
            Log.i(TAG, "User denied required permissions with never ask!\n" + getStringFromList(perms));
            final Intent i = new Intent();
            i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            i.addCategory(Intent.CATEGORY_DEFAULT);
            i.setData(Uri.parse("package:" + getActivity().getPackageName()));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            getActivity().startActivity(i);
        }

    };

    public static String getStringFromList(List<String> list) {
        String result = "[ ";
        int size = list.size();
        for (int i = 0; i < size; i++) {
            result += list.get(i);
            if (i == size - 1) {
                result += " ]";
            } else {
                result += ", ";
            }
        }
        return result;
    }*/

    /*private void webserviceDemo() {

        //Implement LoopjInterface

        // Without File
        new LoopjRequest(MainActivity.this,
                LoopjRequest.Method.POST,
                ApiManager.USER_LOGIN,
                RequestParam.registerUser(),
                RequestParam.getNull(),
                RequestCode.CODE_USER_GET_ALL_MAINTENANCE,
                true,
                this);

        // With File
        new LoopjRequest(getActivity(),
                LoopjRequest.Method.POST,
                ApiManager.USER_NEW_MAINTENANCE,
                RequestParam.newMaintenance("" + mEdTitle.getText().toString().trim(), "" + mEdDescription.getText().toString().trim(), "" + selectedCategoryId, "" + mTxtLatitude.getText().toString(), "" + mTxtLongitude.getText().toString(), "" + location, "" + PreferenceManager.getInstance().getUserName(), "" + PreferenceManager.getInstance().getUserEmail(), "" + PreferenceManager.getInstance().getUserContact()),
                RequestParam.defaultHeader(getActivity()),
                fileArray,
                PermissionCode.CODE_USER_NEW_MAINTENANCE,
                true,
                this);
    }

    @Override
    public void onLoopjStart(int requestId) {
        // Notify when API request start.
    }

    @Override
    public void onLoopjSuccess(int requestId, int statusCode, byte[] bytes) {
        // Receive API response in bytes and convert it in string

        String response = "";
        if (bytes == null) {
            response = "null";
        } else {
            response = new String(bytes);
        }

        LogUtil.i(TAG, "Response:" + response);

        switch (requestId) {
            case RequestCode.CODE_USER_GET_ALL_MAINTENANCE:
                try {
                    JSONObject root = new JSONObject("" + response);
                    String status = root.getString("status");
                    String message = root.getString("message");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    public void onLoopjFailure(int requestId, int statusCode, byte[] bytes, Throwable error) {
        // Receive API response in bytes.
    }

    @Override
    public void onLoopjFinish(int requestId) {
        // Notify when API request finish.
    }*/

    /*private void cameraGalleryDemo()
    {
        // Configure in onCreate() or onCreateView()
        EasyImage.configuration(getActivity())
                .setImagesFolderName("EasyImage");
    }

    private void cameraIntent() {
        EasyImage.openCamera(getActivity(), 0);
    }

    private void galleryIntent() {
        EasyImage.openGallery(getActivity(), 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        LogUtil.i("IssueFragment", "onActivityResult(" + requestCode + "," + resultCode + "," + data + ")");

        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
                LogUtil.i("IssueFragment", "onImagePickerError:" + e.getMessage());
            }

            @Override
            public void onImagesPicked(@NonNull List<File> imageFiles, EasyImage.ImageSource source, int type) {
                onPhotosReturned(imageFiles);
            }
        });
    }

    private void onPhotosReturned(List<File> returnedPhotos) {
        Log.i("IssueFragment", "onImagePicked:" + returnedPhotos);
        if (returnedPhotos.size() > 0) {
            File selectedImage = returnedPhotos.get(0);
            setImage(selectedImage);
        }
    }

    private void setImage(File myFile) {
        if (myFile != null) {
            if (!myFile.exists()) {
                Log.i("Image", "Not exist");
            } else {
                Log.i("Image", "exist");
            }

            // Check in which image view we have to set selected image
            switch (IMG_ID) {
                case 1:
                    imgPath1 = myFile;
                    CommonUtil.setSquareImageToGlide(getActivity(), mImg1, myFile.getAbsolutePath());
                    mTxtMessage.setVisibility(View.GONE);
                    break;
            }
        }
    }

    private void removeTempImage() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".VHIOA");
        deleteCreatedFolder(file);
    }

    public static boolean deleteCreatedFolder(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            if (files == null) {
                return true;
            }
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteCreatedFolder(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }*/

    private void fragmentDemo() {
        /*new FragmentUtil().replaceFragment(HomeActivity.this,
                R.id.container,
                SettingFragment.newInstance(),
                "SettingFragment",
                FragmentUtil.ANIMATION_TYPE.SLIDE_LEFT_TO_RIGHT);*/

        /*new FragmentUtil().removeFragment(getActivity(),
                R.id.container,
                this,
                FragmentUtil.ANIMATION_TYPE.SLIDE_LEFT_TO_RIGHT);*/
    }

    private void blurViewDemo() {
        //CommonUtil.setBlurView(getActivity(), lnrConfirmedInfo, lnrCompletedQuestionaries);
    }

    private void findDistanceDemo() {
        //double distance = new DistanceCalculator().DistanceCalculator(mSharedPreference.getString(VariableBag.USERLATITUDE, "0.0"), mSharedPreference.getString(VariableBag.USERLONGITUDE, "0.0"), hotelLat, hotelLng, "K", 1);
    }

    private void rangebarDemo() {
        /*// Rangebar Example
        RangeSeekBar mRangeAge = (RangeSeekBar) findViewById(R.id.rangeAge);
        RangeSeekBar mRangeDistance = (RangeSeekBar) findViewById(R.id.rangeDistance);

        mRangeAge.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Integer minValue, Integer maxValue) {
                mMinAge = minValue;
                mMaxAge = maxValue;
                mTxtAgeValue.setText(mMinAge + " - " + mMaxAge);
                LogUtil.i("Seekbar Age", "getAbsoluteMaxValue:" + bar.getAbsoluteMaxValue() + " - getAbsoluteMinValue:" + bar.getAbsoluteMinValue() + " - getSelectedMaxValue:" + bar.getSelectedMaxValue() + " - getSelectedMinValue:" + bar.getSelectedMinValue());
                LogUtil.i("Age", "minAge : " + mMinAge + " maxAge : " + mMaxAge);
            }
        });

        mRangeDistance.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Integer minValue, Integer maxValue) {
                mDistance = maxValue;
                mTxtDistanceValue.setText(mDistance + " km");
                LogUtil.i("Seekbar Distance", "getAbsoluteMaxValue:" + bar.getAbsoluteMaxValue() + " - getAbsoluteMinValue:" + bar.getAbsoluteMinValue() + " - getSelectedMaxValue:" + bar.getSelectedMaxValue() + " - getSelectedMinValue:" + bar.getSelectedMinValue());
                LogUtil.i("Distance", "minAge : " + minValue + " maxAge : " + maxValue);
            }
        });

        <com.example.rangeseekbar.RangeSeekBar
        android:id="@+id/rangeAge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingBottom="5dp"
        android:paddingLeft="25dp"
        android:paddingRight="25dp"
        android:paddingTop="5dp"
        rsb:absoluteMaxValue="60"
        rsb:absoluteMinValue="18"
        rsb:activateOnDefaultValues="true"
        rsb:activeColor="@color/header_golden"
        rsb:barHeight="1dp"
        rsb:showLabels="false"
        rsb:thumbDisabled="@drawable/custom_slider_thumb"
        rsb:thumbNormal="@drawable/custom_slider_thumb"
        rsb:thumbPressed="@drawable/custom_slider_thumb"
        rsb:thumbShadow="true"
        rsb:thumbShadowBlur="3dp"
        rsb:thumbShadowXOffset="1dp"
        rsb:thumbShadowYOffset="2dp" />

        <com.example.rangeseekbar.RangeSeekBar
                        android:id="@+id/rangeDistance"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:paddingBottom="5dp"
                        android:paddingLeft="25dp"
                        android:paddingRight="25dp"
                        android:paddingTop="5dp"
                        rsb:absoluteMaxValue="50"
                        rsb:activateOnDefaultValues="true"
                        rsb:activeColor="@color/header_golden"
                        rsb:barHeight="1dp"
                        rsb:showLabels="false"
                        rsb:singleThumb="true"
                        rsb:thumbDisabled="@drawable/custom_slider_thumb"
                        rsb:thumbNormal="@drawable/custom_slider_thumb"
                        rsb:thumbPressed="@drawable/custom_slider_thumb"
                        rsb:thumbShadow="true"
                        rsb:thumbShadowBlur="3dp"
                        rsb:thumbShadowXOffset="1dp"
                        rsb:thumbShadowYOffset="2dp" />
        */
    }
}
