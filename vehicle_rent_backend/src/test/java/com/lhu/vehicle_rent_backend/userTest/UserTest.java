package com.lhu.vehicle_rent_backend.userTest;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.lhu.vehicle_rent_backend.DAO.UserMng;
import com.lhu.vehicle_rent_backend.DTO.User;

public class UserTest {
	private static AnnotationConfigApplicationContext context;      
    private static UserMng userMng; 
    
    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.lhu.vehicle_rent_backend");
        context.refresh();
        userMng = (UserMng)context.getBean("userMng");
    }

    @Test
    public void testUser() {
        
        // add operation
    	User user1 = new User();      
    	
    	user1.setEmail("test1@emai.com");
    	user1.setPassword("abc23");
    	user1.setTp("0777894561");
    	user1.setRole("admin");
    	user1.setImage("imagOne");
    	user1.setStatus("Pending");   
        assertEquals("Successfully added",true,userMng.modifyUser(user1, 1));
        
        /*User user2 = new User();    
        user2.setEmail("test2@emai.com");
    	user2.setPassword("abc99");
    	user2.setTp("0777894000");
    	user2.setRole("admin");
    	user2.setImage("imagTwo");
    	user2.setStatus("Pending");         
        assertEquals("Successfully added",true,userMng.modifyUser(user2, 1));
        
        user1.setEmail("lahiru@emai.com");
        assertEquals("Successfully updated",true,userMng.modifyUser(user1, 2));
        
        assertEquals("Successfully deleted",true,userMng.modifyUser(user2, 3));
                
        //fetching the list
        assertEquals("Successfully fetched",1,userMng.getUsers().size());        
     */           
        
    } 

}
