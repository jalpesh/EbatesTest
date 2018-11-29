package test.ebates.jalpesh.ebatesflickr.services;

import test.ebates.jalpesh.ebatesflickr.MainApplication;
import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;
import test.ebates.jalpesh.ebatesflickr.utils.CommonSharedPref;

public class ApiUtils {

    public static FlickrApiInterface getApiService() {
        return RetrofitClient.getClient(AppConstants.API_CONSTANTS.FLICKR_BASE_URL).create(FlickrApiInterface.class);
    }
}
