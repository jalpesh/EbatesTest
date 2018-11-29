
package test.ebates.jalpesh.ebatesflickr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlickrPhotoHolder {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public FlickrPhotoHolder withPhotos(Photos photos) {
        this.photos = photos;
        return this;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public FlickrPhotoHolder withStat(String stat) {
        this.stat = stat;
        return this;
    }

}
