package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.domain.MyResult;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.respository.GirlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    // 数据库事务注解，girlA 和 girlB要么都成功，要么都不成功
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRespository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBBB");
        girlB.setAge(19);
        girlRespository.save(girlB);
    }

    //处理GirlController 的 checkAge 方法
    public MyResult<Girl> checkAge(Integer id) throws GirlException{
        Girl girl = girlRespository.findOne(id);
        Integer age = girl.getAge();
        //表单验证
        if (age <= 10){
            // 你还在上小学吧
//            throw new GirlException(100, "你还在上小学吧");

            //使用枚举
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if(age < 16) {
            //你可能在上初中
//            throw new GirlException(101, "你可能在上初中");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //大于16岁
        //...
        return new MyResult<Girl>(ResultEnum.SUCCESS, null);
    }

    /**
     * 通过id查询女生
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }
}
