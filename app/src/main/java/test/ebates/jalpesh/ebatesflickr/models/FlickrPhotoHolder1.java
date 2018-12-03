package test.ebates.jalpesh.ebatesflickr.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FlickrPhotoHolder1 implements Parcelable{

    private long photoId;
    private String ownerId;
    private String secret;
    private int serverId;
    private int farmId;
    private String title;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.photoId);
        dest.writeString(this.ownerId);
        dest.writeString(this.secret);
        dest.writeInt(this.serverId);
        dest.writeInt(this.farmId);
        dest.writeString(this.title);
        dest.writeParcelable((Parcelable) this.CREATOR, flags);
    }

    private final Creator<FlickrPhotoHolder1> CREATOR = new Creator<FlickrPhotoHolder1>() {

        @Override
        public FlickrPhotoHolder1 createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public FlickrPhotoHolder1[] newArray(int size) {
            return new FlickrPhotoHolder1[size];
        }
    };


}
