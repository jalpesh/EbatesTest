package test.ebates.jalpesh.ebatesflickr;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import de.greenrobot.event.EventBus;
import test.ebates.jalpesh.ebatesflickr.helpers.DataFetchHelper;
import test.ebates.jalpesh.ebatesflickr.models.Photo;
import test.ebates.jalpesh.ebatesflickr.models.RefreshDataEvent;
import test.ebates.jalpesh.ebatesflickr.ui.main.PhotosFragment;
import test.ebates.jalpesh.ebatesflickr.ui.main.SinglePhotoFragment;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;
import test.ebates.jalpesh.ebatesflickr.utils.CommonUtils;

public class MainActivity extends AppCompatActivity  implements PhotosFragment.OnListFragmentInteractionListener  {

    private boolean imageIsHidden = false;
    private ImageView titleImageView;
    private ValueAnimator mAnimator;
    private ProgressBar waitForLoader;
    private final String singlePhotoFragTag = "SINGLE_PIC_FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        titleImageView = this.findViewById(R.id.img_item_image);
        waitForLoader = this.findViewById(R.id.waiting_progress_bar);

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if(CommonUtils.checkWifiAndMobileConnection(this)){
            startDataFetch();
        } else {
            internetNotFoundAlert();
        }
    }

    private void internetNotFoundAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert).setMessage(R.string.unable_to_connect).setPositiveButton("Ok", activityFinishListner).show();
    }

    DialogInterface.OnClickListener activityFinishListner = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                finishAffinity();
                finish();
            }
        }
    };

    private void startDataFetch(){
        DataFetchHelper.getInstance(this).initServices();
        DataFetchHelper.getInstance(this).fetchAndSetData();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    public void onEventMainThread(RefreshDataEvent refreshDataEvent) {
        waitForLoader.setVisibility(View.GONE);
        this.findViewById(R.id.container).setVisibility(View.VISIBLE);

        showPhotosList();
    }

    private void showPhotosList() {
        String photoListingFragTag = "PIC_LISTING_FRAG";
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, PhotosFragment.newInstance(1), photoListingFragTag)
                .commitNow();
    }

    public void animateUpImage(){

        if(!imageIsHidden){
            imageIsHidden=!imageIsHidden;
            int finalHeight = titleImageView.getHeight();

            mAnimator = slideAnimator(finalHeight, 0);

            mAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    //Height=0, but it set visibility to GONE
                    titleImageView.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            mAnimator.start();
        }
    }

    public void animateDownImage(){

        if(imageIsHidden){
            imageIsHidden=!imageIsHidden;
            titleImageView.setVisibility(View.VISIBLE);

            titleImageView.measure(View.MeasureSpec.makeMeasureSpec(titleImageView.getWidth(), View.MeasureSpec.EXACTLY),View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            final int targetHeight = titleImageView.getMeasuredHeight();

            mAnimator = slideAnimator(0, targetHeight);
            mAnimator.setDuration(800);
            mAnimator.start();

        }
    }

    private ValueAnimator slideAnimator(int start, int end) {
        ValueAnimator mAnimator = ValueAnimator.ofInt(start, end);

        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = titleImageView.getLayoutParams();
                layoutParams.height = value;
                titleImageView.setLayoutParams(layoutParams);
            }
        });
        return mAnimator;
    }

    @Override
    public void onListFragmentInteraction(Photo item) {
        LaunchSingleView(item);
    }

    public void LaunchSingleView(Photo item){
        titleImageView.setVisibility(View.GONE);
        SinglePhotoFragment singlePhotoFragment = new SinglePhotoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.COMMON_CONSTANTS.PHOTO_PARCEL, item);
        singlePhotoFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, singlePhotoFragment,singlePhotoFragTag)
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if( getSupportFragmentManager().getFragments().size()>0 && getSupportFragmentManager().getFragments().get(0).getTag().equalsIgnoreCase(singlePhotoFragTag)){
            titleImageView.setVisibility(View.VISIBLE);
            startDataFetch();
            showPhotosList();
        }else {
            super.onBackPressed();
        }
    }
}
