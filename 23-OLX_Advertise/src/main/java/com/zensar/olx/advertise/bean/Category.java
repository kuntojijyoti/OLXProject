package com.zensar.olx.advertise.bean;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Embeddable
public class Category {
@Column(name="olx_category")
private int id;@Transient
private String name;@Transient
private String description;
public Category(int id, String name, String description) {
super();
this.id = id;
this.name = name;
this.description = description;
}
public Category(String name, String description) {
super();
this.name = name;
this.description = description;
}
public Category(int id) {
super();
this.id = id;
}
public Category() {
super();
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
@Override
public String toString() {
return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
}
@Override
public int hashCode() {
return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Category other = (Category) obj;
return id == other.id;
}
}

