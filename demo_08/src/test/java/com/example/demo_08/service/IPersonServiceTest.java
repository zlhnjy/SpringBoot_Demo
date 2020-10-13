package com.example.demo_08.service;


import com.alibaba.fastjson.JSON;
import com.example.demo_08.entity.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 19:31
 * @Description:
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IPersonServiceTest {

    @Autowired
    private IPersonService personService;

    @Test
    public void save() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("zhangsan");
        personEntity.setAge(10);
        personEntity = personService.save(personEntity);
        System.out.println(JSON.toJSONString(personEntity, true));
    }

    @Test
    public void list() {
        List<PersonEntity> personEntityList = personService.list();
        System.out.println(JSON.toJSONString(personEntityList, true));
    }

    @Test
    public void testSave() {
        personService.testSave();
    }

    @Test
    public void testSaveBatch() {
        long s = System.currentTimeMillis();

        List<PersonEntity> personEntities = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            personEntities.add(new PersonEntity("name" + i, i));
        }
        personEntities = personService.save(personEntities);
        System.out.println(personEntities.size());

        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    @Test
    public void testSaveBatch2() throws InterruptedException {
        long s = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(20);
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int j = 0; j < 20; j++) {
            executorService.submit(() -> {
                Connection connection = null;
                try {
                    connection = dataSource.getConnection();
                    StringBuilder stringBuilder = new StringBuilder("insert into person (age, name) values ");
                    for(int i=0; i<10000; i++) {
                        stringBuilder.append("(").append(i).append(", 'name").append(i).append("')");
                        if (i<9999){
                            stringBuilder.append(",");
                        }
                    }
                    System.out.println(stringBuilder.toString());
                    PreparedStatement ps = connection.prepareStatement(stringBuilder.toString());
                    ps.execute();
                    ps.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(countDownLatch);
            });
        }

        countDownLatch.await();

        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    @Test
    public void testSaveBatch3() throws SQLException, InterruptedException {
        long s = System.currentTimeMillis();

        Connection connection = dataSource.getConnection();
//        connection.setAutoCommit(false);
//        String sql = "insert into person (age, name) values (?, ?)";
        StringBuilder stringBuilder = new StringBuilder("insert into person (age, name) values ");
        for(int i=0; i<10000; i++) {
            stringBuilder.append("(").append(i).append(", 'name").append(i).append("')");
            if (i<9999){
                stringBuilder.append(",");
            }
        }
        System.out.println(stringBuilder.toString());
        PreparedStatement ps = connection.prepareStatement(stringBuilder.toString());
        ps.execute();
        ps.close();
        connection.close();

//        int count = 1;
//        for (int i = 0; i < 100000; i++) {
//            ps.setInt(1, i);
//            ps.setString(2, "name" + i);
//            ps.addBatch();
//            if (count++ == 10000) {
//                System.out.println(count);
//                ps.executeBatch();
//                count = 1;
//            }
//        }
//        ps.executeBatch();
//        ps.close();
//        connection.setAutoCommit(true);
//        connection.close();


        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    @Autowired
    private DataSource dataSource;

}