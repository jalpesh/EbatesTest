package test.ebates.jalpesh.ebatesflickr.helpers;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.ebates.jalpesh.ebatesflickr.MainApplication;
import test.ebates.jalpesh.ebatesflickr.models.FlickrPhotoHolder;
import test.ebates.jalpesh.ebatesflickr.services.ApiUtils;
import test.ebates.jalpesh.ebatesflickr.services.FlickrApiInterface;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;
import test.ebates.jalpesh.ebatesflickr.utils.CommonSharedPref;

public class DataFetchHelper {

    FlickrApiInterface flickrApiInterface;
    static DataFetchHelper mInstance = null;
    private Context mContext;

    private DataFetchHelper(Context context){
        mContext = context;
    }

    public static DataFetchHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new DataFetchHelper(context);
        }
        return mInstance;
    }

    public void initServices(){
        //Init service
        flickrApiInterface = ApiUtils.getApiService();

        //Init local cache

    }

    public void fetchAndSetData(){

        int currentPageNumber = CommonSharedPref.getInt(MainApplication.getAppContext(), AppConstants.SHARED_PREF_CONSTS.CURR_PAGE_NO, 0) + 1;

        flickrApiInterface.getRecents(currentPageNumber).enqueue(new Callback<FlickrPhotoHolder>() {
            @Override
            public void onResponse(Call<FlickrPhotoHolder> call, Response<FlickrPhotoHolder> response) {
                Log.d("Response",response.body().getPhotos().toString());
            }

            @Override
            public void onFailure(Call<FlickrPhotoHolder> call, Throwable t) {
                Log.d("Response","it failed");
            }
        });

    }

}
