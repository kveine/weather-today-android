package recyclerView;

/**
 * Created by Kristin on 18.04.2016.
 */
public class DataModel {
    private String name;
    private String temp;
   // private String image;

    public DataModel(String name, String temp){
        this.name = name;
        this.temp = temp;
        //this.image = image;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getTemp(){
        return temp;
    }

    public void setTemp(){
        this.temp = temp;
    }

   /* public String getImage(){
        return image;
    }

    public void setImage(){
        this.name = name;
    }*/

}
