package test.ebates.jalpesh.ebatesflickr.helpers;

import android.content.Context;
import android.util.Log;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.ebates.jalpesh.ebatesflickr.MainApplication;
import test.ebates.jalpesh.ebatesflickr.models.FlickrPhotoHolder;
import test.ebates.jalpesh.ebatesflickr.models.RefreshDataEvent;
import test.ebates.jalpesh.ebatesflickr.services.ApiUtils;
import test.ebates.jalpesh.ebatesflickr.services.FlickrApiInterface;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;
import test.ebates.jalpesh.ebatesflickr.utils.CommonSharedPref;

public class DataFetchHelper{

    private FlickrApiInterface flickrApiInterface = null;
    private static DataFetchHelper mInstance = null;
    private FlickrPhotoHolder localPhotosCache = new FlickrPhotoHolder();

    private DataFetchHelper(Context context){
        Context mContext = context;
    }

    public static DataFetchHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new DataFetchHelper(context);
        }
        return mInstance;
    }

    public void initServices(){
        //Init service
        if(flickrApiInterface==null){
            flickrApiInterface = ApiUtils.getApiService();
        }

        //Init local cache

    }

    public void fetchAndSetData(){

        int currentPageNumber = CommonSharedPref.getInt(MainApplication.getAppContext(), AppConstants.SHARED_PREF_CONSTS.CURR_PAGE_NO, 0) + 1;

        flickrApiInterface.getRecents(currentPageNumber).enqueue(new Callback<FlickrPhotoHolder>() {
            @Override
            public void onResponse(Call<FlickrPhotoHolder> call, Response<FlickrPhotoHolder> response) {
                //Log.d("Response",response.body().getPhotos().toString());
                //check if more pages of data are available then load more
                localPhotosCache = response.body();
                //sennd evnt to UI to refresh layout adapter

                EventBus.getDefault().post(new RefreshDataEvent());
            }

            @Override
            public void onFailure(Call<FlickrPhotoHolder> call, Throwable t) {
                Log.d("Response","it failed");
            }
        });

    }

    public FlickrPhotoHolder getLocalPhotosCache(){
        return localPhotosCache;
    }

}
