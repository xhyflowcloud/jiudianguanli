package com.ccnu.xiahongyun.stmanagementsystem;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentInfoMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.UserMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.StudentImformation;
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
	private UserMapper userMapper;
	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Test
	public void contextLoads() {
	}


	@Test
	@Rollback
	public void findByName() throws Exception {

	    userMapper.insertUser(1L,"AAAAA", 12);
        User e = userMapper.findUserById(1L);
        System.out.println(e.getName());
    }

    @Test
	@Rollback
	public void TestStudentInfoMapper(){
		//studentInfoMapper.insertStudentInfo(1231,123);
		//studentInfoMapper.insertStudentInfo(1232,123);
		//StudentImformation s = studentInfoMapper.findStudentInfoByExamid(1231);
		//System.out.println(s.getExamid() + " " + s.getSbid());
		studentInfoMapper.deleteStudentInfoByExamid(1231);
	}
}
