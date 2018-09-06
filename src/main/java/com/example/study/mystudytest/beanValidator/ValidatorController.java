package com.example.study.mystudytest.beanValidator;

import com.example.study.global.AppResponse;
import com.example.study.mystudytest.beanValidator.Info1;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by louis on 2018/9/5.
 */
@RestController
@RequestMapping()
public class ValidatorController {


    @PostMapping(value = "postV1", consumes = "application/json")
    public String validate(@RequestBody @Valid Info1 info1, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "postV1~~~~";
    }


    @PostMapping(value = "postV2", consumes = "application/json")
    public String validate111111(@RequestBody Info1 info1){
        return "postV2~~~~";
    }



    @GetMapping(value = "getV2")
    public AppResponse validateGet2(@RequestParam(name="value") Integer value , @RequestParam String name){
        return new AppResponse(0, "getV2~~~");
    }
}

