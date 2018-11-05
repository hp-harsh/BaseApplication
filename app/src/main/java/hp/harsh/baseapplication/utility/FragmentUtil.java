package hp.harsh.baseapplication.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import hp.harsh.baseapplication.R;

/**
 * Created by Harsh on 2/5/2016.
 */
public class FragmentUtil {

    private int containerId;
    private Fragment fragment;
    private String currentFragmentTag;
    private String fragmentTag;
    private FragmentActivity activity;

    public enum ANIMATION_TYPE {
        SLIDE_UP_TO_DOWN, SLIDE_UP_TO_DOWN_BOUNCE, SLIDE_DOWN_TO_UP, SLIDE_LEFT_TO_RIGHT, SLIDE_RIGHT_TO_LEFT, NONE
    }

    public void replaceFragment(FragmentActivity activity, int containerId, Fragment fragment, String fragmentTag, ANIMATION_TYPE animationType) {
        this.containerId = containerId;
        this.fragment = fragment;
        this.fragmentTag = fragmentTag;
        this.activity = activity;

        Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);

        if (frag != null) {
            if (!frag.getTag().equals("" + fragmentTag)) {
                switch (animationType) {
                    case SLIDE_UP_TO_DOWN:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_UP_TO_DOWN_BOUNCE:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top_bounce, R.anim.exit_bottom).replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_DOWN_TO_UP:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_LEFT_TO_RIGHT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_RIGHT_TO_LEFT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    default:
                        this.activity.getSupportFragmentManager().beginTransaction().replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                }
            }
        } else {
            this.activity.getSupportFragmentManager().beginTransaction().replace(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
        }
    }

    public void addFragment(FragmentActivity activity, int containerId, Fragment fragment, String fragmentTag, ANIMATION_TYPE animationType) {
        this.containerId = containerId;
        this.fragment = fragment;
        this.fragmentTag = fragmentTag;
        this.activity = activity;

        Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);

        if (frag != null) {
            if (!frag.getTag().equals("" + fragmentTag)) {
                switch (animationType) {
                    case SLIDE_UP_TO_DOWN:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_UP_TO_DOWN_BOUNCE:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top_bounce, R.anim.exit_bottom).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_DOWN_TO_UP:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_LEFT_TO_RIGHT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    case SLIDE_RIGHT_TO_LEFT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                    default:
                        this.activity.getSupportFragmentManager().beginTransaction().add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
                        break;
                }
            }
        } else {
            this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).add(this.containerId, this.fragment, this.fragmentTag).commitAllowingStateLoss();
        }
    }

    public void removeFragment(FragmentActivity activity, int containerId, Fragment fragment, ANIMATION_TYPE animationType) {
        this.fragment = fragment;
        this.activity = activity;
        this.containerId = containerId;

        Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);
        Log.i("frag", "" + frag);

        if (frag != null) {
            Log.i("frag.getTag()", "" + frag.getTag());
            if (!frag.getTag().equals("" + fragmentTag)) {
                switch (animationType) {
                    case SLIDE_UP_TO_DOWN:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).remove(this.fragment).commitAllowingStateLoss();
                        break;
                    case SLIDE_UP_TO_DOWN_BOUNCE:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top_bounce, R.anim.exit_bottom).remove(this.fragment).commitAllowingStateLoss();
                        break;
                    case SLIDE_DOWN_TO_UP:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).remove(this.fragment).commitAllowingStateLoss();
                        break;
                    case SLIDE_LEFT_TO_RIGHT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).remove(this.fragment).commitAllowingStateLoss();
                        break;
                    case SLIDE_RIGHT_TO_LEFT:
                        this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).remove(this.fragment).commitAllowingStateLoss();
                        break;
                    default:
                        this.activity.getSupportFragmentManager().beginTransaction().remove(this.fragment).commitAllowingStateLoss();
                        break;
                }
            }
        } else {
            this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).remove(this.fragment).commitAllowingStateLoss();
        }
    }
}
