package hu.bme.aut.mobsoft.tripplanviewer.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.client.model.City;
//import io.swagger.client.model.Sight;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class CityWithSights   {
  
  @SerializedName("city")
  private City city = null;
  
  @SerializedName("sights")
  private List<Sight> sights = new ArrayList<Sight>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public City getCity() {
    return city;
  }
  public void setCity(City city) {
    this.city = city;
  }

  
  /**
   * The sights in the city
   **/
  @ApiModelProperty(value = "The sights in the city")
  public List<Sight> getSights() {
    return sights;
  }
  public void setSights(List<Sight> sights) {
    this.sights = sights;
  }

  

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    CityWithSights cityWithSights = (CityWithSights) o;
//    return Objects.equals(city, cityWithSights.city) &&
//        Objects.equals(sights, cityWithSights.sights);
//  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(city, sights);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CityWithSights {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    sights: ").append(toIndentedString(sights)).append("\n");
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
