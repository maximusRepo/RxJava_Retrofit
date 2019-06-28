package com.example.apicall;

import com.google.gson.annotations.SerializedName;

public class GetResponse {

    @SerializedName("active")
    String active;

    @SerializedName("iden")
    String iden;

    @SerializedName("created")
    String created;

    @SerializedName("modified")
    String modified;

    @SerializedName("email")
    String email;

    @SerializedName("email_normalized")
    String email_normalized;

    @SerializedName("name")
    String name;

    @SerializedName("image_url")
    String image_url;

    @SerializedName("max_upload_size")
    String max_upload_size;
}
