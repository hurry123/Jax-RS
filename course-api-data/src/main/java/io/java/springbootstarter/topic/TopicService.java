package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework" ,"Spring Description"),
			new Topic("hibernate","Hibernate ORM" ,"Hibernate Description"),
			new Topic("java8","Java 8" ,"Core java Description")
			));
	 
	public List<Topic> getAllTopics() {
		
		//return topics;

		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		
	}
	
	public Topic getTopic(String id){
		
		return topicRepository.findOne(id);
		
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		/* below code will work too for Java 1.7 & less
		 * for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equalsIgnoreCase(id)){
				 return topics.get(i);
			}
		}
		return null;*/
	}

	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
		topicRepository.save(topic);
		
		/*for(int i = 0; i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
	}

	public void deleteTopic(String id) {
		
		topicRepository.delete(id);
		
	/*	for(int i = 0; i <topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.remove(i);
				return;
			}
		}*/
	}
	
	
	
	
}
