public class Content {
  //keyword final makes vars imutable
  private final String title;
  private final String imageURL;

  public Content(String title, String imageURL) {
    //this.title is the title of this Class instance / Obj
    //the var name title makes the code look for the closest var in scope
    this.title = title;
    this.imageURL = imageURL;
  }
  public String getTitle() {
    return title;
  }
  public String getImageURL() {
    return imageURL;
  }

}
