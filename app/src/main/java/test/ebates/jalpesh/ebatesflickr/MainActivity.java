package test.ebates.jalpesh.ebatesflickr;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import de.greenrobot.event.EventBus;
import test.ebates.jalpesh.ebatesflickr.helpers.DataFetchHelper;
import test.ebates.jalpesh.ebatesflickr.models.RefreshDataEvent;
import test.ebates.jalpesh.ebatesflickr.ui.main.PhotosFragment;

public class MainActivity extends AppCompatActivity {

    boolean imageIsHidden = false;
    ImageView titleImageView;
    private ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        titleImageView = this.findViewById(R.id.img_item_image);

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        startDataFetch();
    }

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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, PhotosFragment.newInstance(1))
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

}
