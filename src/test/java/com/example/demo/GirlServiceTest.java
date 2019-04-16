package com.example.demo;

import com.example.demo.domain.Girl;
import com.example.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class) //在测试环境运行
@SpringBootTest //启动整个Spring工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(10);
        Assert.assertEquals(new Integer(10), girl.getAge());
    }
}
