package com.sp.controller;

import com.google.code.kaptcha.Constants;
import com.sp.entity.Emp;
import com.sp.entity.Menu;
import com.sp.service.BaseService;
import com.sp.service.EmpService;
import com.sp.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
@RequestMapping("/EmpController")
public class EmpController extends BaseController<Emp> {

    @Autowired
    private EmpService empService;

    @Autowired
    private MenuService menuService;

    @Override
    protected BaseService<Emp> getBaseService() {
        return empService;
    }


    //注册用户，进行密码加密
    @RequestMapping(value = "/addEmp",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addEmp(Emp emp) {

        //获取密码
        String password = emp.getPassword();

        //随即撒盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        password = new SimpleHash("md5",password,salt,2).toString();  //将密码进行盐加密

        //将加密后的密码 存储进对象
        emp.setSalt(salt);
        emp.setPassword(password);

        int i = getBaseService().insertSelective(emp);

        return isTrueOrFalse(i);
    }


    //登录
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Model model) {
        //获取存进Session中的真实验证码
        String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        //获取输入的验证码
        String yzm = request.getParameter("yzm");

        //判断验证码
        if(!code.equalsIgnoreCase(yzm)) {
            model.addAttribute("msg","验证码错误！");
            return "redirect:/toLogin";
        }

        //获取输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);

            //登录通过了，获取Session
            Session session = subject.getSession();
            //通过用户名获取它的对象
            Emp emp = empService.getEmpByUsername(username);
            //通过它对象的id获取它的所有菜单
            Set<Menu> setMenu = menuService.getSetMenuByEmpId(emp.getId());

            session.setAttribute("setMenu",setMenu);
            session.setAttribute("emp",emp);
            return "redirect:/index";
        } catch (AuthenticationException e) {
            model.addAttribute("msg","用户名或密码错误！");
            return "redirect:/toLogin";
        }

    }


    @RequestMapping("/getEmpById/{id}")
    public String getEmpById(@PathVariable Integer id,Model model) {
        Emp emp = empService.selectByPrimaryKey(id);

        model.addAttribute("emp",emp);
        return "emp/updatePassword";
    }


    //修改密码
    @RequestMapping(value = "/updatePassword",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updatePassword(Emp emp) {

        //获取输入的密码
        String password = emp.getPassword();

        //随即撒盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        password = new SimpleHash("md5",password,salt,2).toString();  //将密码进行盐加密

        //将加密后的密码 存储进对象
        emp.setSalt(salt);
        emp.setPassword(password);

        int i = getBaseService().updateByPrimaryKey(emp);

        return isTrueOrFalse(i);
    }




}
