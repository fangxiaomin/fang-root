package com.fang;

import com.fang.user.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang
 * @author:fxm
 * @createTime:2021/8/25 15:33
 * @version:1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        User user =new User();
        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @Test
    public void getOrderById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/getOrderById")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id","10") ///入参  ，对应 @RequestParam
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void addUser() throws Exception{
        String json="{\"name\":\"HAHAHAA\",\"age\":\"11\"}";
        mvc.perform(MockMvcRequestBuilders.post("/user/addUser")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数，参数是对象
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testException() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/testException/1")  //  这种就是@PathVariable 。参数直接在  url 后面跟着
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())  //方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
//                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("嘟嘟MD独立博客"))  这里jsonPath用来获取author字段比对是否为嘟嘟MD独立博客,不是就测试不通过
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot干货系列"))
                .andDo(MockMvcResultHandlers.print()); //添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
    }


}
