package hu.bme.aut.mobsoft.tripplanviewer.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Sight   {
  
  @SerializedName("id")
  private String id = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("cityid")
  private String cityid = null;
  

  
  /**
   * Unique identifier of the sight
   **/
  @ApiModelProperty(value = "Unique identifier of the sight")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Name of the sight
   **/
  @ApiModelProperty(value = "Name of the sight")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * The identifier of the city where the sight is.
   **/
  @ApiModelProperty(value = "The identifier of the city where the sight is.")
  public String getCityid() {
    return cityid;
  }
  public void setCityid(String cityid) {
    this.cityid = cityid;
  }

  

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    Sight sight = (Sight) o;
//    return Objects.equals(id, sight.id) &&
//        Objects.equals(name, sight.name) &&
//        Objects.equals(cityid, sight.cityid);
//  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name, cityid);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sight {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cityid: ").append(toIndentedString(cityid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
