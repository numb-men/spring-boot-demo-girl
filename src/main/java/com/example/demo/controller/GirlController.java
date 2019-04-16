package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.domain.MyResult;
import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.respository.GirlRespository;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRespository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls") //等同于@RequestParam("cupSize") String cupSize,
                                    //@RequestParam("age") Integer age
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) throws GirlException{
        //@Valid 设置验证对象，bindingResult是验证结果
        if (bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());

//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());

            return ResultUtils.error(103, bindingResult.getFieldError().getDefaultMessage());
            // 上下两句代码等同
        }

//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlRespository.save(girl));
//        return result;

        return ResultUtils.success(girlRespository.save(girl));
    }

    /**
     * 查询女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRespository.findOne(id);
    }


    /**
     * 更新女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRespository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRespository.delete(id);
    }

    /**
     * 根据年龄查找女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    @PostMapping(value = "/girl/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/checkAge/{id}")
    public MyResult getAge(@PathVariable("id") Integer id){
        return girlService.checkAge(id);
    }
}
