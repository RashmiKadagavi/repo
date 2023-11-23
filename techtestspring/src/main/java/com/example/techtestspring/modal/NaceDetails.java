package com.example.techtestspring.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "nacedata_details")
public class NaceDetails {
    public String getLevel() {
        return level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "level")
    private String level;
    @Column(name = "code")
    private String code;
    @Column(name = "parent")
    private String parent;
    @Column(name = "description")
    private String description;
    @Column(name = "rulings")
    private String rulings;

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }



    @Column(name = "reference_isic")
    private String reference_isic;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThis_item_includes() {
        return this_item_includes;
    }

    public void setThis_item_includes(String this_item_includes) {
        this.this_item_includes = this_item_includes;
    }

    public String getThis_item_also_includes() {
        return this_item_also_includes;
    }

    public void setThis_item_also_includes(String this_item_also_includes) {
        this.this_item_also_includes = this_item_also_includes;
    }

    public String getThis_item_excludes() {
        return this_item_excludes;
    }

    public void setThis_item_excludes(String this_item_excludes) {
        this.this_item_excludes = this_item_excludes;
    }

    @Column(name = "this_item_includes",columnDefinition ="LONGTEXT")
    private String this_item_includes;
    @Column(name = "this_item_also_includes",columnDefinition ="LONGTEXT")
    private String this_item_also_includes;
    @Column(name = "this_item_excludes",columnDefinition ="LONGTEXT")
    private String this_item_excludes;

    public NaceDetails() {
    }

    @Override
    public String toString() {
        return "NaceDetails{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", description='" + description + '\'' +
                ", rulings='" + rulings + '\'' +
                ", reference_isic='" + reference_isic + '\'' +
                ", this_item_includes='" + this_item_includes + '\'' +
                ", this_item_also_includes='" + this_item_also_includes + '\'' +
                ", this_item_excludes='" + this_item_excludes + '\'' +
                '}';
    }

    public NaceDetails(long id, String level, String code, String parent, String description, String this_item_includes, String this_item_also_includes, String rulings, String this_item_excludes, String reference_isic) {
        this.id = id;
        this.level = level;
        this.code=code;
        this.parent=parent;
        this.description=description;
        this.this_item_includes=this_item_includes;
        this.this_item_also_includes=this_item_also_includes;
        this.rulings=rulings;
        this.this_item_excludes=this_item_excludes;
        this.reference_isic=reference_isic;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
