import com.godwei.ssmframe.controller.UserController;
import com.godwei.ssmframe.model.User;
import com.godwei.ssmframe.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.misc.Version.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/spring-webmvc.xml"})
public class testUserController {

    @Autowired
    private UserController userController;

    MockMvc mockMvc;
    @Before
    public void setUp() {
         mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUser() throws Exception{
        System.out.println("--------分割线----------");
        try {
            mockMvc.perform(get("/user/getall"))
                    .andDo(MockMvcResultHandlers.print());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
