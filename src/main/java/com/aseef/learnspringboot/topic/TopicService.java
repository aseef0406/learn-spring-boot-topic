package com.aseef.learnspringboot.topic;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("1","Java","Java Language"),
//			new Topic("2","JavaScript","JavaScript Language"),
//			new Topic("3","C++","C++ Language")
//			)) ;
	
	public List<Topic> getAllTopics() {
//		return topics;
		List<Topic> alltopic = new ArrayList<>();
		topicRepository.findAll()
						.forEach(alltopic::add);
		return alltopic;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		
//		topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
//		int nooftopics=topics.size();
//		for(int i=0;i<nooftopics;i++) {
//			Topic t = topics.get(i);
//			if(id.equals(t.getId())) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicRepository.save(topic);
		
	}

	public void removeTopic(String id) {
		
//		topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
		
	}
}
