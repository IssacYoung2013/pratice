package test;

import com.issac.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-20
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestJdbcTemplate2 {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void test(){
        template.execute("insert into user VALUES (4,'issac')");
    }

    @Test
    public void test2() {
        // 第一个参数：要执行的SQL语句
        // 第二个参数：结果映射处理器（RowMapper）
        // 第三个参数：SQL语句中的入参
        List<User> userList = template.query("SELECT * FROM USER ",
                new MyBeanMapper(),null);
        
        System.out.println(userList);
    }
}

/**
 * 结果映射器
 */
class MyBeanMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        User account = new User();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        return account;

    }
}