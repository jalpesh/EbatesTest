package test.ebates.jalpesh.ebatesflickr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.greenrobot.event.EventBus;
import test.ebates.jalpesh.ebatesflickr.helpers.DataFetchHelper;
import test.ebates.jalpesh.ebatesflickr.models.RefreshDataEvent;
import test.ebates.jalpesh.ebatesflickr.ui.main.PhotosFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {

        }

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
                .replace(R.id.container, PhotosFragment.newInstance(2))
                .commitNow();
    }
}
