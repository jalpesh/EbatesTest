package test.ebates.jalpesh.ebatesflickr.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FlickrPhotoHolder1 implements Parcelable{

    long photoId;
    String ownerId;
    String secret;
    int serverId;
    int farmId;
    String title;

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

    Creator<FlickrPhotoHolder1> CREATOR = new Creator<FlickrPhotoHolder1>() {

        @Override
        public FlickrPhotoHolder1 createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public FlickrPhotoHolder1[] newArray(int size) {
            return new FlickrPhotoHolder1[size];
        }
    };

    public FlickrPhotoHolder1() {
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
