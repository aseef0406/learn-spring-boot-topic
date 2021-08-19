package com.aseef.learnspringboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aseef.learnspringboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) { //@PathVariable("uri parameter") when uri have different parameter w.r.t function parameter
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
//		System.out.println(id+" Course: "+Course.toString());
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="topics/{topicId}/courses/{id}")
	public void removeCourse(@PathVariable String id) {
		courseService.removeCourse(id);
	}
	
}
