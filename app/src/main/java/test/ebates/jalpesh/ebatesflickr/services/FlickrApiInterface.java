package test.ebates.jalpesh.ebatesflickr.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.ebates.jalpesh.ebatesflickr.models.FlickrPhotoHolder;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;

public interface FlickrApiInterface {


    @GET(AppConstants.API_CONSTANTS.FLICKR_GET_RECENTS_URL)
    Call<FlickrPhotoHolder> getRecents(@Query("page_no") int userId);
}
