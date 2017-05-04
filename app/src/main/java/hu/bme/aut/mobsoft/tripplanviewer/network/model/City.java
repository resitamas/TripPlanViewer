package hu.bme.aut.mobsoft.tripplanviewer.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class City   {
  
  @SerializedName("id")
  private String id = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("coutry")
  private String coutry = null;
  

  
  /**
   * Unique identifier of the city
   **/
  @ApiModelProperty(value = "Unique identifier of the city")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Name of the city
   **/
  @ApiModelProperty(value = "Name of the city")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Country where the city is.
   **/
  @ApiModelProperty(value = "Country where the city is.")
  public String getCoutry() {
    return coutry;
  }
  public void setCoutry(String coutry) {
    this.coutry = coutry;
  }

  

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    City city = (City) o;
//    return Objects.equals(id, city.id) &&
//        Objects.equals(name, city.name) &&
//        Objects.equals(coutry, city.coutry);
//  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name, coutry);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coutry: ").append(toIndentedString(coutry)).append("\n");
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
