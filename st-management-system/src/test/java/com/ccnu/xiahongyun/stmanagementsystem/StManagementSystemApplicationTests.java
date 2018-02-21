package com.ccnu.xiahongyun.stmanagementsystem;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.UserMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StManagementSystemApplication.class)
public class StManagementSystemApplicationTests {

	@Autowired
	private ClassroomMapper cs;

	@Test
	public void contextLoads() {
	}


	@Test
	@Rollback
	public void insertClassroom() throws Exception {

	    cs.insertClassroom(20,"jianren");

    }
	@Test
	@Rollback
	public void findByName() throws Exception {

		Classroom c= cs.findClassroomById(1);
		System.out.println(c.getPosition());

	}
}
