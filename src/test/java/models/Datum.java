package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Datum {
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("first_name")
    @Expose
    String firstName;
    @SerializedName("last_name")
    @Expose
    String lastName;
    @SerializedName("avatar")
    @Expose
    String avatar;
}
