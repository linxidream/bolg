package com.example.mybolg.web;

import com.example.mybolg.common.result.ResultInfo;
import com.example.mybolg.entity.User;
import com.example.mybolg.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private Logger logger= LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/findAll")
    @ResponseBody
    public ResultInfo findAll(){
        logger.info("------->>>>>---method>>:"+this.getClass().getName());
        logger.info("param>>in---------------------------");
        ResultInfo resultInfo= new ResultInfo();
        try{
            List<User> userList=userService.getAll();
            resultInfo.setSuccessInfo(resultInfo,userList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            resultInfo.setUnknowErrorInfo(resultInfo,ResultInfo.ResultCode.UNKNOW_ERROR, ResultInfo.ResultCode.UNKNOW_ERROR_MSG_CN);
            return resultInfo;
        }
        logger.info("---------------->>>>--------method end--------<<<<---------");
        return resultInfo;
    }

    @RequestMapping(value="/login")
    @ResponseBody
    public ResultInfo userLogin(@RequestBody User user){
        ResultInfo resultInfo=new ResultInfo();
        logger.info("------->>>>>---method>>:"+this.getClass().getName());
        logger.info("param>>in---------------------------");
        try{
            if(StringUtils.isBlank(user.getName())){
                resultInfo.setClientErrorInfo(resultInfo,"user name can't be null");
                return resultInfo;
            }
            if(StringUtils.isBlank(user.getPassword())){
                resultInfo.setClientErrorInfo(resultInfo,"user password can't be null");
            }

            resultInfo.setSuccessInfo(resultInfo,obj);
        }catch(Exception e){
            resultInfo.setUnknowErrorInfo(resultInfo,ResultInfo.ResultCode.UNKNOW_ERROR, ResultInfo.ResultCode.UNKNOW_ERROR_MSG_CN);
        }
        logger.info("---------------->>>>--------method end--------<<<<---------");
        return resultInfo;
    }
}
