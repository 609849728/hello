package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sp.service.BaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController<T> {

    //需要子类实例化
    protected abstract BaseService<T> getBaseService();

    private Class<T> type;

    //泛型T的类名且是小写的，比如类名为User，那么就是user
    private String className;

    //子类的类上@RequestMapping中value的属性值
    private String requestMappingValue;

    private Gson gson = new Gson();


    public BaseController() {
        /*
        返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        超类：BaseController
        然后将其转换成ParameterizedType
         */
        ParameterizedType types = (ParameterizedType) this.getClass().getGenericSuperclass();

        //返回表示此类型实际类型参数的 Type 对象的数组，简而言之就是获得超类的泛型参数的实际类型
        Type[] typeArguments = types.getActualTypeArguments();

        /*
        当子类public class DeptController extends BaseController<Dept>
        因为只有一个，所以[0]，也就是Dept的类型
         */
        type = (Class<T>) typeArguments[0];

        //获取类名，并转成小写
        className = type.getSimpleName().toLowerCase();


        //----------------------------------------------------------------------------------------------------


        //获取@RequestMapping的注解对象
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);

        /*
        value()：返回的是一个String[]，因为注解可能有多个属性，比如value、name、method等
        这里暂时只考虑只存在一个value的情况，所以取[0]，就比如：@RequestMapping(value="xxx")
        String value = xxx;
         */
        requestMappingValue = requestMapping.value()[0];
    }


    //处理结果，json数据
    public String isTrueOrFalse(int i) {
        Map<String,Object> map = new HashMap<>();

        if(i > 0) {
            map.put("flag",true);
            map.put("msg","操作成功！");
        } else {
            map.put("flag",false);
            map.put("msg","操作失败！");
        }

        return gson.toJson(map);
    }


    //查询所有信息，分页，支持模糊查询
    @RequestMapping("/getPageInfo")
    public String getPageInfo(Integer pageNum, Integer pageSize, T t, Model model) {
        PageInfo pageInfo = getBaseService().getPageInfo(pageNum, pageSize, t);

        model.addAttribute("pageUrl",getPageUrl(t));
        model.addAttribute("page",pageInfo);
        return className+"/"+className+"List";
    }


    //处理模糊查询时的分页
    public String getPageUrl(T t) {
        //分页的url
        StringBuffer pageUrl = new StringBuffer(requestMappingValue+"/getPageInfo?");

        //通过反射获取该对象的所有属性，返回一个Field[]数组，一个Field对象对应一个属性
        Field[] declaredFields = t.getClass().getDeclaredFields();

        //遍历所有属性
        for(int i=0; i<declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);  //设置权限可用
            try {
                Object value = field.get(t);  //获取到属性的值
                if(value != null) {  //如果不为空，就将pageUrl进行拼接
                    //getName()：属性名称
                    pageUrl.append(field.getName()+"="+value.toString()+"&");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return pageUrl.toString();
    }


    //添加
    @RequestMapping(value = "/add",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String add(T t) {
        int i = getBaseService().insertSelective(t);

        return isTrueOrFalse(i);
    }


    //根据id查询信息
    @RequestMapping("/getById/{id}")
    public String getById(@PathVariable Integer id,Model model) {
        T t = getBaseService().selectByPrimaryKey(id);

        model.addAttribute(className,t);
        return className+"/"+className+"Update";
    }


    //修改信息
    @RequestMapping(value = "/update",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String update(T t) {
        int i = getBaseService().updateByPrimaryKeySelective(t);

        return isTrueOrFalse(i);
    }


    //删除信息
    @RequestMapping(value = "/delete/{id}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        int i = getBaseService().deleteByPrimaryKey(id);

        if(i > 0) {
            return "true";
        }
        return "false";
    }


    //批量删除
    @RequestMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(Integer[] ids) {
        int i = getBaseService().batchDelete(ids);

        if(i > 0) {
            return "true";
        }
        return "false";
    }


}
