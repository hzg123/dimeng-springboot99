package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.mondel.Sales;
import com.jk.mondel.Tree;
import com.jk.service.TreeService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */
@RestController
public class TreeController  extends BaseController{


    @Autowired
    private TreeService treeService;

    //查树
    @RequestMapping("/treeList")
    public void getTree(HttpServletRequest request, String callback, Tree tree, HttpServletResponse response) throws Exception {
        List<Tree> list= treeService.getTreeList1(tree);
        String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");

        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);

    }
    //查询数据
    @RequestMapping("/findSales")
    public void findSales(HttpServletRequest request,String callback,HttpServletResponse response,Sales sales) throws Exception {

        List<Sales> userList = treeService.findSales(sales);
        String json = JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss");

        json=callback+"("+json+")";
        super.outString(json, response);
    }
    //新增
    @RequestMapping("/saveSales")
    public void saveSales(Sales sales,HttpServletRequest request,HttpServletResponse response){

        treeService.saveSales(sales);

    }
    //查询
    @RequestMapping("/findSales2")
    public void findSales2(HttpServletRequest request,String callback,HttpServletResponse response,Sales sales) throws Exception {

        List<Sales> userList = treeService.findSales(sales);
        String json = JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss");

        json=callback+"("+json+")";
        super.outString(json, response);
    }

}