package com.zensar.olx.advertise.bean;
import java.util.Objects;

public class AdvertisementPostRequest {
	
int id;
String title;
int categoryId;
String description;
double price;
int statusId;
public AdvertisementPostRequest(int id, String title, int categoryId, String description, double price) {
super();
this.id = id;
this.title = title;
this.categoryId = categoryId;
this.description = description;
this.price = price;
}
public AdvertisementPostRequest(String title, int categoryId, String description, double price) {
super();
this.title = title;
this.categoryId = categoryId;
this.description = description;
this.price = price;
}
public AdvertisementPostRequest(int id) {
super();
this.id = id;
}
public AdvertisementPostRequest() {
super();
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getTitle() {
return title;
}
public void setTitle(String title) {
this.title = title;
}
public int getCategoryId() {
return categoryId;
}
public void setCategoryId(int categoryId) {
this.categoryId = categoryId;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public double getPrice() {
return price;
}
public void setPrice(double price) {
this.price = price;
}

public int getStatusId() {
	return statusId;
}
public void setStatusId(int statusId) {
	this.statusId = statusId;
}
@Override
public String toString() {
return "AdvertisementPostRequest [id=" + id + ", title=" + title + ", categoryId=" + categoryId + ", description="
+ description + ", price=" + price + "]";
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
AdvertisementPostRequest other = (AdvertisementPostRequest) obj;
return id == other.id;
}}

