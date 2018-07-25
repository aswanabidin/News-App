package mumtaazstudio.newsapp.model;

public class ArticlesModel {

    private String author;
    private String title;
    private String description;
    private String published;
    private String url;
    private String urlImage;

    public ArticlesModel() {
    }

    public ArticlesModel(String author, String title, String description, String published, String url, String urlImage) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.published = published;
        this.url = url;
        this.urlImage = urlImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
