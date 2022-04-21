package com.example2.demo1.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aliyun.oss.model.OSSObject;
import com.example2.demo1.common.BaseResult;
import com.example2.demo1.config.ConstantPropertiesUtils;
import com.example2.demo1.model.MobileModel;
import com.example2.demo1.service.MobileServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/study-api/mobile")
public class mobile {
    @Autowired
    private  RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate  MyRedisTemplate;

    @Autowired
    MobileServiceImpl mobileService;


    @RequestMapping("/homepage/json")
    public BaseResult index() {
        // 将 JSON 字符串存入 redis // 反序列化问题
        ValueOperations valueOperations = MyRedisTemplate.opsForValue();
        JSONObject jsonObject = new JSONObject();
        Object ListData =  valueOperations.get("homePage");
        if (ListData == null){
            String line = null;
            String line2 = ""; // 读取文件流
            String endpoint = ConstantPropertiesUtils.ENDPOINT;
            String accessKeyId = ConstantPropertiesUtils.KEYID;
            String accessKeySecret = ConstantPropertiesUtils.KEYSECRET;
            String bucketName = ConstantPropertiesUtils.BUCKETNAME;
            String objectName = "tb/home.json";
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            try {
                // 读取文件流
                OSSObject ossObject = ossClient.getObject(bucketName, objectName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
                while (true) {
                    line = reader.readLine();
                    if (line == null) break;
                    line2 += line;
                }
                reader.close();
                // 将数据存入 redis
                valueOperations.set("homePage", line2);
            }catch (OSSException oe) {
                System.out.println("读取OSS错误");
            }catch(Exception e) {
                System.out.println("执行错误");
            }catch (Throwable e) {
                ossClient.shutdown();
            }
            ListData = line2;
        }
        JSONObject param= JSON.parseObject(ListData.toString());
        param.put("code", 200);
        return BaseResult.success("接口获取成功",param);
    }

    @GetMapping("/goods/list/paged")
    public BaseResult getMobileGoodsShowInList(@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageIndex) {
        PageInfo<MobileModel> pageInfo=mobileService.queryAll(pageIndex,pageSize);
        return BaseResult.success("获取接口成功",pageInfo);
    }

    }
