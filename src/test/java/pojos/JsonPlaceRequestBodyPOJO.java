package pojos;

public class JsonPlaceRequestBodyPOJO {

    /*
     {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    // 1 - Obje icerisindeki tum key degerlerini class levelda private variable olarak hazirla
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2 - Getter - Setter lari hazirla


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3 - Tum parametreleri iceren Constructor olustur

    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4 - Parametresiz Constructor olustur

    public JsonPlaceRequestBodyPOJO() {
    }

    // 5 - toString() methodu olustur

    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +
                "title='" + title + '\'' + // {title='Ahmet', body='Merhaba' ,userId=70, id=3}
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
