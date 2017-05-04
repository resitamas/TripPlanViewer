package hu.bme.aut.mobsoft.tripplanviewer.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Trip   {

  @SerializedName("id")
  private String id = null;

  @SerializedName("userid")
  private String userid = null;

    @SerializedName("name")
  private String name = null;


  public enum VisibilityEnum {
    @SerializedName("Private")
    PRIVATE("Private"),

    @SerializedName("Public")
    PUBLIC("Public");

    private String value;

    VisibilityEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  @SerializedName("visibility")
  private VisibilityEnum visibility = null;

  @SerializedName("distance")
  private Integer distance = null;

  @SerializedName("days")
  private Integer days = null;

  @SerializedName("citiesWithSights")
  private List<CityWithSights> citiesWithSights = new ArrayList<CityWithSights>();



  /**
   * Unique identifier of the trip.
   **/
  @ApiModelProperty(value = "Unique identifier of the trip.")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }


  /**
   * The id of the user who owns the trip.
   **/
  @ApiModelProperty(value = "The id of the user who owns the trip.")
  public String getUserid() {
    return userid;
  }
  public void setUserid(String userid) {
    this.userid = userid;
  }


  /**
   * The name of the trip
   **/
  @ApiModelProperty(value = "The name of the trip")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  public VisibilityEnum getVisibility() {
    return visibility;
  }
  public void setVisibility(VisibilityEnum visibility) {
    this.visibility = visibility;
  }


  /**
   * The distance of the trip
   **/
  @ApiModelProperty(value = "The distance of the trip")
  public Integer getDistance() {
    return distance;
  }
  public void setDistance(Integer distance) {
    this.distance = distance;
  }


  /**
   * The number of the the trip last
   **/
  @ApiModelProperty(value = "The number of the the trip last")
  public Integer getDays() {
    return days;
  }
  public void setDays(Integer days) {
    this.days = days;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  public List<CityWithSights> getCitiesWithSights() {
    return citiesWithSights;
  }
  public void setCitiesWithSights(List<CityWithSights> citiesWithSights) {
    this.citiesWithSights = citiesWithSights;
  }



//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    Trip trip = (Trip) o;
//    return Objects.equals(id, trip.id) &&
//        Objects.equals(userid, trip.userid) &&
//        Objects.equals(name, trip.name) &&
//        Objects.equals(visibility, trip.visibility) &&
//        Objects.equals(distance, trip.distance) &&
//        Objects.equals(days, trip.days) &&
//        Objects.equals(citiesWithSights, trip.citiesWithSights);
//  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, userid, name, visibility, distance, days, citiesWithSights);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trip {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
    sb.append("    citiesWithSights: ").append(toIndentedString(citiesWithSights)).append("\n");
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
