package hu.bme.aut.mobsoft.tripplanviewer.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.client.model.Trip;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class User   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("owntrips")
  private List<Trip> owntrips = new ArrayList<Trip>();
  
  @SerializedName("othertrips")
  private List<Trip> othertrips = new ArrayList<Trip>();
  

  
  /**
   * The name of the user
   **/
  @ApiModelProperty(value = "The name of the user")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * The created trips
   **/
  @ApiModelProperty(value = "The created trips")
  public List<Trip> getOwntrips() {
    return owntrips;
  }
  public void setOwntrips(List<Trip> owntrips) {
    this.owntrips = owntrips;
  }

  
  /**
   * Other trips
   **/
  @ApiModelProperty(value = "Other trips")
  public List<Trip> getOthertrips() {
    return othertrips;
  }
  public void setOthertrips(List<Trip> othertrips) {
    this.othertrips = othertrips;
  }

  

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    User user = (User) o;
//    return Objects.equals(name, user.name) &&
//        Objects.equals(owntrips, user.owntrips) &&
//        Objects.equals(othertrips, user.othertrips);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(name, owntrips, othertrips);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    owntrips: ").append(toIndentedString(owntrips)).append("\n");
    sb.append("    othertrips: ").append(toIndentedString(othertrips)).append("\n");
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
