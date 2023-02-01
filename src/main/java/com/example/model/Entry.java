package com.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry implements Serializable {
    @JsonProperty("API")
    private String Api;
    @Id
    private String Link;
@JsonProperty("Description")
    private String Description;
@JsonProperty("Auth")
    private String Auth;
    @JsonProperty("HTTPS")
    private boolean HTTPS;

@JsonProperty("Cors")
    private String Cors;
    @JsonProperty("Category")
    private String category;

    public Entry toEntry() {
        return new Entry(this.Api,this.Link,this.Description,this.Auth,this.HTTPS,this.Cors,this.category);
    }
}
