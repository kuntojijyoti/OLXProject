package com.zensar.olx.advertise.rest;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import com.zensar.olx.advertise.bean.Advertisement;
import com.zensar.olx.advertise.bean.AdvertisementPostRequest;
import com.zensar.olx.advertise.bean.AdvertisementPostResponse;
import com.zensar.olx.advertise.bean.AdvertisementStatus;
import com.zensar.olx.advertise.bean.Category;
import com.zensar.olx.advertise.bean.OlxUser;
import com.zensar.olx.advertise.service.AdvertisementService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdvertisementController {



@Autowired
AdvertisementService service;

@PostMapping("/advertise/{un}")
public AdvertisementPostResponse add(@RequestBody AdvertisementPostRequest request,@PathVariable(name="un")String username)
{
Advertisement advt=new Advertisement();
advt.setTitle(request.getTitle());
advt.setPrice(request.getPrice());
advt.setDescription(request.getDescription());

int categoryId=request.getCategoryId();

RestTemplate restTemplate=new RestTemplate();
Category category;
String url="http://localhost:9052/advertise/getCategoryById/" + categoryId;
category=restTemplate.getForObject(url, Category.class);
advt.setCategory(category);

url="http://localhost:9051/findUserByName/"+username;
OlxUser olxuser=restTemplate.getForObject(url, OlxUser.class);
advt.setOlxUser(olxuser);

AdvertisementStatus advertisementStatus=new AdvertisementStatus(1,"OPEN");
advt.setAdvertisementstatus(advertisementStatus);

Advertisement advertisement=this.service.addAdvertisement(advt);
AdvertisementPostResponse response=new AdvertisementPostResponse();
response.setId(advertisement.getId());
response.setTitle(advertisement.getTitle());
response.setPrice(advertisement.getPrice());
response.setCategory(advertisement.getCategory().getName());
response.setDescription(advertisement.getDescription());
response.setUserName(advertisement.getOlxUser().getUsername());
response.setCreatedDate(advertisement.getCreateDate());
response.setModifiedDate(advertisement.getModifiedDate());
response.setStatus(advertisement.getAdvertisementstatus().getStatus());



return response;
}
@PutMapping("/advertise/{aid}/{userName}")
public AdvertisementPostResponse f2(@RequestBody AdvertisementPostRequest request, @PathVariable(name="aid")int id, @PathVariable(name="userName")String username)
{
Advertisement advt=this.service.getAdvertisementById(id);

advt.setTitle(request.getTitle());
advt.setDescription(request.getDescription());
advt.setPrice(request.getPrice());

RestTemplate restTemplate=new RestTemplate();

Category category;
String url="http://localhost:9052/advertise/getCategoryById/"+ request.getCategoryId();
category=restTemplate.getForObject(url, Category.class);
advt.setCategory(category);

url="http://localhost:9051/findUserByName/" +username;
OlxUser olxuser=restTemplate.getForObject(url, OlxUser.class);
advt.setOlxUser(olxuser);

url="http://localhost:9052/advertise/status/" +request.getStatusId();
AdvertisementStatus advertisementStatus;
advertisementStatus=restTemplate.getForObject(url, AdvertisementStatus.class);
advt.setAdvertisementstatus(advertisementStatus);

Advertisement advertisement=this.service.updateAdvertisement(advt);

AdvertisementPostResponse postResponse;
postResponse = new AdvertisementPostResponse();

postResponse.setId(advertisement.getId());
postResponse.setTitle(advertisement.getTitle());
postResponse.setDescription(advertisement.getDescription());
postResponse.setPrice(advertisement.getPrice());
postResponse.setUserName(advertisement.getOlxUser().getUsername());
postResponse.setCategory(advertisement.getCategory().getName());
postResponse.setCreatedDate(advertisement.getCreateDate());
postResponse.setModifiedDate(advertisement.getModifiedDate());
postResponse.setStatus(advertisement.getAdvertisementstatus().getStatus());


return postResponse;




}

@GetMapping("/user/advertise/{username}")
public List<AdvertisementPostResponse> f3(@PathVariable(name="username")String userName){
	
	List<Advertisement> advPosts= this.service.getAllAdvertisement();
	
	RestTemplate restTemplate=new RestTemplate();
	String url="http://localhost:9051/findUserByName/"+userName;
	OlxUser olxUser=restTemplate.getForObject(url, OlxUser.class);
	
	List<Advertisement> filterList=new ArrayList<>();
	
	
	for(Advertisement post:advPosts) {
		Category category;
		url="http://localhost:9052/advertise/getCategoryById/"+post.getCategory().getId();
		category=restTemplate.getForObject(url, Category.class);
		post.setCategory(category);
		System.out.println("Category------"+post);
		
		url="http://localhost:9052/advertise/status/"+post.getAdvertisementstatus().getId();
		
		AdvertisementStatus advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
		post.setAdvertisementstatus(advertisementStatus);
		System.out.println("AdvertisemntStatus"+post);
		
		if(olxUser.getUserId()==post.getOlxUser().getUserId()) {
			post.setOlxUser(olxUser);
			filterList.add(post);
		}
	}
	System.out.println("List-----------"+filterList);
	List<AdvertisementPostResponse> responseList=new ArrayList<>();
	for(Advertisement advertisementPost:filterList)
	{
		AdvertisementPostResponse  postRespone=new AdvertisementPostResponse();
		postRespone.setId(advertisementPost.getId());
		postRespone.setTitle(advertisementPost.getTitle());
		postRespone.setDescription(advertisementPost.getDescription());
		postRespone.setPrice(advertisementPost.getPrice());
		postRespone.setUserName(advertisementPost.getOlxUser().getUsername());
		postRespone.setCategory(advertisementPost.getCategory().getName());
		postRespone.setCreatedDate(advertisementPost.getCreateDate());
		postRespone.setModifiedDate(advertisementPost.getModifiedDate());
		postRespone.setStatus(advertisementPost.getAdvertisementstatus().getStatus());
		responseList.add(postRespone);
	
		
	}
	return responseList;
}

@GetMapping("/user/advertiseById/{advId}")
public AdvertisementPostResponse f4(@PathVariable(name="advId")int  advertisementId) {
	AdvertisementPostResponse response=new AdvertisementPostResponse();
	
	Advertisement advt=this.service.getAdvertisementById(advertisementId);
	
	RestTemplate restTemplate =new RestTemplate();
	String url;
	
	Category category;
	url="http://localhost:9052/advertise/getCategoryById/"+advt.getCategory().getId();
	category=restTemplate.getForObject(url, Category.class);
	advt.setCategory(category);
	System.out.println("Category----"+advt);
	
	url="http://localhost:9052/advertise/status/"+advt.getAdvertisementstatus().getId();
	AdvertisementStatus advetisementStatus;
	advetisementStatus =restTemplate.getForObject(url,AdvertisementStatus.class);
	advt.setAdvertisementstatus(advetisementStatus);
	
	url="http://localhost:9051/findUserById/"+advt.getOlxUser().getUserId();
	OlxUser olxuser =restTemplate.getForObject(url,OlxUser.class);
	advt.setOlxUser(olxuser);
	
	response.setId(advt.getId());
	response.setTitle(advt.getTitle());
	response.setDescription(advt.getDescription());
	response.setPrice(advt.getPrice());
	response.setUserName(advt.getOlxUser().getUsername());
	response.setCategory(advt.getCategory().getDescription());
	response.setCreatedDate(advt.getCreateDate());
	response.setModifiedDate(advt.getModifiedDate());
	response.setStatus(advt.getAdvertisementstatus().getStatus());
	return response;
	
}


@DeleteMapping("/user/advertiseById/{advId}")



public boolean f5(@PathVariable(name="advId")int advertisementId)
{
Advertisement advt=this.service.getAdvertisementById(advertisementId);
boolean result= this.service.deleteAdvertisement(advt);
return result;
}

@GetMapping("/advertise/search/{criteria}")
public List<AdvertisementPostResponse> f6(@PathVariable(name="criteria")String criteria){



List<Advertisement> advPosts=this.service.getAllAdvertisement();



String[] text=criteria.split(":");

List<Advertisement> f=new ArrayList<>();






for(Advertisement post: advPosts) {
RestTemplate restTemplate=new RestTemplate();
String url="http://localhost:9051/findUserById/"+ post.getOlxUser().getUserId();
OlxUser olxUser=restTemplate.getForObject(url, OlxUser.class);
post.setOlxUser(olxUser);



Category category;
url="http://localhost:9052/advertise/getCategoryById/"+post.getCategory().getId();
category=restTemplate.getForObject(url, Category.class);
post.setCategory(category);
System.out.println(("Category-----"+post));



url="http://localhost:9052/advertise/status/"+post.getAdvertisementstatus().getId();
AdvertisementStatus advertisementStatus;
advertisementStatus=restTemplate.getForObject(url, AdvertisementStatus.class);
post.setAdvertisementstatus(advertisementStatus);
System.out.println("AdvertisementStatus"+post);

if(text[0].equalsIgnoreCase("Title")) {
if(post.getTitle().contains(text[1])) {
f.add(post);
}
}
if(text[0].equalsIgnoreCase("category")) {
if(post.getCategory().getName().contains(text[1])) {
f.add(post); }
}
if(text[0].equalsIgnoreCase("description")) {
if(post.getDescription().contains(text[1])) {
f.add(post); }
}
if(text[0].equalsIgnoreCase("createdDate")) {
if(post.getCreateDate().equals(text[1])) {
f.add(post); }
}
if(text[0].equalsIgnoreCase("modifiedDate")) {
if(post.getModifiedDate().equals(text[1])) {
f.add(post); }
}




}
System.out.println("List------------"+f);



List<AdvertisementPostResponse> responseList=new ArrayList<>();
for(Advertisement advertisementPost:f) {
AdvertisementPostResponse postresponse=new AdvertisementPostResponse();




postresponse.setId(advertisementPost.getId());
postresponse.setTitle(advertisementPost.getTitle());
postresponse.setPrice(advertisementPost.getPrice());
postresponse.setCategory(advertisementPost.getCategory().getName());
postresponse.setDescription(advertisementPost.getDescription());
postresponse.setUserName(advertisementPost.getOlxUser().getUsername());
postresponse.setCreatedDate(advertisementPost.getCreateDate());
postresponse.setModifiedDate(advertisementPost.getModifiedDate());
postresponse.setStatus(advertisementPost.getAdvertisementstatus().getStatus());
responseList.add(postresponse);
}

return responseList;







}
}

