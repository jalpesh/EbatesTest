package test.ebates.jalpesh.ebatesflickr.utils;

public class AppConstants {

    public static class COMMON_CONSTANTS{
        public static String DOWNLOAD_CHECK_INTENT = "checkDownloadServiceIntentFlag";
        public static String DOWNLOAD_START_INTENT = "startDownloadServiceIntentFlag";
        public static String DOWNLOAD_CALLBACK_LISTNER = "startDownloadServiceListner";

        public static int CHECK_IF_DOWNLOAD_IS_AVAILABLE = 197;
        public static int DOWNLOAD_IS_AVAILABLE = 198;
        public static int DOWNLOAD_IS_NOT_AVAILABLE = 198;
        public static int DOWNLOAD_VERIFICATION_FAILED = 195;

        public static int START_DOWNLOAD_INTENT = 196;
        public static int DOWNLOAD_IS_COMPLETED = 199;
        public static int DOWNLOAD_FAILED = 194;
        public static int DOWNLOAD_PROGRESS = 192;
        public static String DOWNLOAD_PROGRESS_VAL = "progress_value";
        public static int BACKUP_CORRUPT = 193;

    }

    public static class DOWNLOAD_URL_CONSTANTS{
        public static String CHECK_BACKUP_URL = "/api/api/v1/backups/%s/canrestore";
        public static String DOWNLOAD_BACKUP_URL = "/api/api/v1/backups/%s/restore";
    }

    public static class SHARED_PREF_CONSTS{
        public static final String BLTH_DSCNCTED = "pref.bluetoothe_disconnected_by_method_in_manager";
        public static final String MANUAL_CALIB_COMPLETED = "pref.ManualCalibDonebyUser";
        public static final String CLICKING_VALUE = "pref.isCurrentlyClicking";
        public static String BACKUP_COMPLETED = "ibe.remote.backup.completed";
    }

    public static class API_CONSTANTS{
        public static String API_KEY = "fee10de350d1f31d5fec0eaf330d2dba";
        public static String FLICKR_BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key="+API_KEY+"&format=json&nojsoncallback=true";
        //farm id :: server :: photoid :: secret :: size
        public static String FLICKR_IMAGE_URL_CONSTRUCTOR = "https://farm%s.staticflickr.com/%s/%s_%s%s.jpg";

        public static class IMAGE_SIZE_CONSTANTS {

            public static final String SMALL_IMAGE_SIZE = "_s";
            public static final String MEDIUM_IMAGE_SIZE = "_m";
            public static final String THUMBNAIL_IMAGE_SIZE = "_t";
            public static final String ORIGINAL_IMAGE_SIZE = "";

        }
    }


}
