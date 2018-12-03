package test.ebates.jalpesh.ebatesflickr.utils;

public class AppConstants {

    public static class SHARED_PREF_CONSTS{
        public static final String CURR_PAGE_NO = "pref.ApiCallPageNumber";
    }

    public static class API_CONSTANTS{

        static final String API_KEY = "fee10de350d1f31d5fec0eaf330d2dba";

        public static final String FLICKR_BASE_URL = "https://api.flickr.com/services/rest/";

        public static final String FLICKR_GET_RECENTS_URL = "?&extras=url_m,url_l, geo&format=json&nojsoncallback=true&method=flickr.photos.getRecent&api_key="+API_KEY;

        //farm id :: server :: photoid :: secret :: size
        public static final String FLICKR_IMAGE_URL_CONSTRUCTOR = "https://farm%s.staticflickr.com/%s/%s_%s%s.jpg";

    }

    public static class IMAGE_SIZE_CONSTANTS {

        public static final String SMALL_IMAGE_SIZE = "_s";
        public static final String MEDIUM_IMAGE_SIZE = "_m";
        public static final String THUMBNAIL_IMAGE_SIZE = "_t";
        public static final String ORIGINAL_IMAGE_SIZE = "";
        public static final String LARGE_IMAGE_SIZE = "_l";

    }


    public class COMMON_CONSTANTS {
        public static final String PHOTO_PARCEL = "parcelKeyForPhotoModel";
    }
}
