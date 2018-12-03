package test.ebates.jalpesh.ebatesflickr.services;

import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;

public class ApiUtils {

    public static FlickrApiInterface getApiService() {
        return RetrofitClient.getClient(AppConstants.API_CONSTANTS.FLICKR_BASE_URL).create(FlickrApiInterface.class);
    }
}
