
package test.ebates.jalpesh.ebatesflickr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("pages")
    @Expose
    private long pages;
    @SerializedName("perpage")
    @Expose
    private long perpage;
    @SerializedName("total")
    @Expose
    private long total;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public Photos withPage(long page) {
        this.page = page;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public Photos withPages(long pages) {
        this.pages = pages;
        return this;
    }

    public long getPerpage() {
        return perpage;
    }

    public void setPerpage(long perpage) {
        this.perpage = perpage;
    }

    public Photos withPerpage(long perpage) {
        this.perpage = perpage;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Photos withTotal(long total) {
        this.total = total;
        return this;
    }

    public List<Photo> getPhotoList() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public Photos withPhoto(List<Photo> photo) {
        this.photo = photo;
        return this;
    }

}
