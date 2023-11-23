package com.example.techtestspring.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Nacedto {
@ApiModelProperty(value ="Order number" )
    @JsonProperty(value="Order")
    private long id;
    private String level;
    private String code;
    private String parent;
    private String description;

    @JsonProperty(value="This item includes")
    private String this_item_includes;
    @JsonProperty(value="This item also includes")
    private String this_item_also_includes;
    private String  rulings;
    @JsonProperty(value="This item excludes")
    private String this_item_excludes;
    @JsonProperty(value="Reference to ISIC Rev. 4")
    private String reference_isic;


}
