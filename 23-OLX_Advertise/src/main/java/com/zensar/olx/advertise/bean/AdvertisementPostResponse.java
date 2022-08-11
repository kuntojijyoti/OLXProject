package com.zensar.olx.advertise.bean;import java.time.LocalDate;
import java.util.Objects;public class AdvertisementPostResponse {
	
int id;
String title;
double price;
String category;
String description;
String userName;
LocalDate createdDate;
LocalDate modifiedDate;
String status;
public AdvertisementPostResponse(int id, String title, double price, String category, String description,
String userName, LocalDate createDate, LocalDate modifiedDate, String status) {
super();
this.id = id;
this.title = title;
this.price = price;
this.category = category;
this.description = description;
this.userName = userName;
this.createdDate = createDate;
this.modifiedDate = modifiedDate;
this.status = status;
}
public AdvertisementPostResponse(String title, double price, String category, String description,
String userName, LocalDate createDate, LocalDate modifiedDate, String status) {
super();
this.title = title;
this.price = price;
this.category = category;
this.description = description;
this.userName = userName;
this.createdDate = createdDate;
this.modifiedDate = modifiedDate;
this.status = status;
}
public AdvertisementPostResponse(int id) {
super();
this.id = id;
this.createdDate = LocalDate.now();
this.modifiedDate = LocalDate.now();}
public AdvertisementPostResponse() {
super();
this.createdDate = LocalDate.now();
this.modifiedDate = LocalDate.now();
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
public double getPrice() {
return price;
}
public void setPrice(double price) {
this.price = price;
}
public String getCategory() {
return category;
}
public void setCategory(String category) {
this.category = category;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public LocalDate getCreatedDate() {
return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
this.createdDate = createdDate;
}
public LocalDate getModifiedDate() {
return modifiedDate;
}
public void setModifiedDate(LocalDate modifiedDate) {
this.modifiedDate = modifiedDate;
}
public String getStatus() {
return status;
}
public void setStatus(String status) {
this.status = status;
}
@Override
public String toString() {
return "AdvertisementPostResponse [id=" + id + ", title=" + title + ", price=" + price + ", category="
+ category + ", description=" + description + ", userName=" + userName + ", createdDate="
+ createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
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
AdvertisementPostResponse other = (AdvertisementPostResponse) obj;
return id == other.id;
}
}

