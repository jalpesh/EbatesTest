
package test.ebates.jalpesh.ebatesflickr.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Switch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import test.ebates.jalpesh.ebatesflickr.utils.AppConstants;

public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private long farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private long ispublic;
    @SerializedName("isfriend")
    @Expose
    private long isfriend;
    @SerializedName("isfamily")
    @Expose
    private long isfamily;

    protected Photo(Parcel in) {
        id = in.readString();
        owner = in.readString();
        secret = in.readString();
        server = in.readString();
        farm = in.readLong();
        title = in.readString();
        ispublic = in.readLong();
        isfriend = in.readLong();
        isfamily = in.readLong();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Photo withId(String id) {
        this.id = id;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Photo withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Photo withSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Photo withServer(String server) {
        this.server = server;
        return this;
    }

    public long getFarm() {
        return farm;
    }

    public void setFarm(long farm) {
        this.farm = farm;
    }

    public Photo withFarm(long farm) {
        this.farm = farm;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Photo withTitle(String title) {
        this.title = title;
        return this;
    }

    public long getIspublic() {
        return ispublic;
    }

    public void setIspublic(long ispublic) {
        this.ispublic = ispublic;
    }

    public Photo withIspublic(long ispublic) {
        this.ispublic = ispublic;
        return this;
    }

    public long getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(long isfriend) {
        this.isfriend = isfriend;
    }

    public Photo withIsfriend(long isfriend) {
        this.isfriend = isfriend;
        return this;
    }

    public long getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(long isfamily) {
        this.isfamily = isfamily;
    }

    public Photo withIsfamily(long isfamily) {
        this.isfamily = isfamily;
        return this;
    }

    public String getPhotoUrl(String imageSize){
        return String.format(AppConstants.API_CONSTANTS.FLICKR_IMAGE_URL_CONSTRUCTOR, getFarm(), getServer(), getId(), getSecret(), imageSize);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(owner);
        dest.writeString(secret);
        dest.writeString(server);
        dest.writeLong(farm);
        dest.writeString(title);
        dest.writeLong(ispublic);
        dest.writeLong(isfriend);
        dest.writeLong(isfamily);
    }
}
