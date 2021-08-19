package com.aseef.learnspringboot.course;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> Courses = new ArrayList<>(Arrays.asList(
//			new Course("1","Java","Java Language"),
//			new Course("2","JavaScript","JavaScript Language"),
//			new Course("3","C++","C++ Language")
//			)) ;
	
	public List<Course> getAllCourses(String topicId) {
//		return Courses;
		List<Course> allCourse = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
						.forEach(allCourse::add);
		return allCourse;
	}
	
	public Course getCourse(String id) {
//		return Courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		
//		Courses.add(Course);
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		
//		int noofCourses=Courses.size();
//		for(int i=0;i<noofCourses;i++) {
//			Course t = Courses.get(i);
//			if(id.equals(t.getId())) {
//				Courses.set(i, Course);
//				return;
//			}
//		}
		courseRepository.save(course);
		
	}

	public void removeCourse(String id) {
		
//		Courses.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
		
	}
}
