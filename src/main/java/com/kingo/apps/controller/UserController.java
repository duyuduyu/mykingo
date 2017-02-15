package com.kingo.apps.controller;

import com.alibaba.fastjson.JSONObject;
import com.kingo.apps.entity.Users;
import com.kingo.apps.service.UserService;
import com.kingo.apps.util.ExceptionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Stephen Sun
 * @date 2017-02-13 14:12
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */
@Controller
@RequestMapping("index")
public class UserController {


    @Autowired
    UserService userService;


    @RequestMapping("main")
    public ModelAndView main(){
        return new ModelAndView("main");
    }


    @RequestMapping("login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("logout")
    public ModelAndView logout(){
        return new ModelAndView("login");
    }

    @RequestMapping("register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping("nop")
    public ModelAndView nopermission() {
        return new ModelAndView("nop");
    }

    @RequestMapping("newuser")
    @ResponseBody
    public JSONObject newUser(@Valid Users users, BindingResult result){
        JSONObject jsonObject = new JSONObject();
        try {
            if(result.hasErrors()){
                List<ObjectError> eList = result.getAllErrors();
                String errorMsg = eList.get(0).getDefaultMessage();
                jsonObject.put("status", 0);
                jsonObject.put("msg", errorMsg);
            }else{
                users.setGistime(new Date());
                userService.register(users);
                ExceptionUtil.getSuccess(jsonObject);
                jsonObject.put("url", "/mykingo/index/login");
            }
        }catch (Exception e){
            ExceptionUtil.getCatch(jsonObject, e);
        }
        return jsonObject;
    }



    @RequestMapping("auth")
    @ResponseBody
    public JSONObject auth(Users users, Model model){
        JSONObject jsonObject = new JSONObject();
        String msg;
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());

            token.setRememberMe(false);

            Subject subject = SecurityUtils.getSubject();

            Session session = subject.getSession();
            try {
                subject.login(token);
                if (subject.isAuthenticated()) {
                    jsonObject.put("msg", "登录成功!");
                    jsonObject.put("state", 1);
                    session.setAttribute("username", users.getUsername());
                    return jsonObject;
                } else {
                    jsonObject.put("msg", "用户名或密码错误!");
                    return jsonObject;
                }
            } catch (IncorrectCredentialsException e) {
                msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (ExcessiveAttemptsException e) {
                msg = "登录失败次数过多";
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (LockedAccountException e) {
                msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (DisabledAccountException e) {
                msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (ExpiredCredentialsException e) {
                msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (UnknownAccountException e) {
                msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            } catch (UnauthorizedException e) {
                msg = "您没有得到相应的授权！" + e.getMessage();
                jsonObject.put("msg", msg);
                jsonObject.put("state", 0);
                model.addAttribute("message", msg);
                System.out.println(msg);
            }
        }catch (Exception e){
            ExceptionUtil.getCatch(jsonObject, e);
        }
        return jsonObject;
    }

}
