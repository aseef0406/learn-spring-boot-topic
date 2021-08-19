package com.aseef.learnspringboot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	//syntax to define method for automatic method implementation by spring-data-jpa
	// find By Property =>findByProperty
	public List<Course> findByName(String name);
	
	// find By Property field =>findByPropertyField
	public List<Course> findByTopicId(String topicId);
}
