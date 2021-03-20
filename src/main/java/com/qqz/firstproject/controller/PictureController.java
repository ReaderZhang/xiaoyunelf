package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-02-11  0:51
*/

import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.bean.GoodsPict;
import com.qqz.firstproject.bean.shopFirPict;
import com.qqz.firstproject.pojo.Goods;
import com.qqz.firstproject.pojo.Picture;
import com.qqz.firstproject.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.qqz.firstproject.Constant.PictureTypeConstant.NAVIGATOR;
import static com.qqz.firstproject.Constant.PictureTypeConstant.SWITCH_TAB;

@RestController
@Api(value = "图片上传模块")
public class PictureController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping("/picture/upload")
    public void upload(@RequestParam("file") MultipartFile file)throws IOException {
        //如果没有设置路径,则会直接保存在项目目录下
//        String rootPath="/META-INF/resources/static/img";
//        String filePath=rootPath+"/"+file.getOriginalFilename ();
        String filePath = file.getOriginalFilename ();
        System.out.println (filePath);
        File filee = new File ( "src/main/resources/static/img/"+filePath );
        System.out.println (filee);
        System.out.println (filee.exists ());
        System.out.println (filee.getAbsolutePath ());
        BufferedOutputStream outputStream = new BufferedOutputStream ( new FileOutputStream ( filee.getAbsolutePath () ) );
        System.out.println (  );
        outputStream.write ( file.getBytes () );
        outputStream.flush ();
        outputStream.close ();
    }
    @RequestMapping("/picture/download")
    public ResponseEntity download() throws  IOException{
        FileSystemResource file = new FileSystemResource ( "54.png" );
        HttpHeaders headers = new HttpHeaders (  );
//        在响应头中添加这个,设置下载文件默认的名称
        headers.add ( "Content-Disposition","attachment; filename=123.jpg" );
        return ResponseEntity.ok (  )
                .headers ( headers )
                .contentLength ( file.contentLength () )
                .contentType ( MediaType.parseMediaType ("application/octet-stream") )
                .body ( new InputStreamResource ( file.getInputStream () ) );
    }
    @GetMapping("/shop/picture")
    public ResponseResult getShopPicture(){
            Picture pictures[] = {new shopFirPict ("47.95.214.19:8080/static/img/yunelf_testneces.png","考试必备",SWITCH_TAB,"/pages/category/main"),
                new Picture("47.95.214.19:8080/img/yunelf_book.png","书"),
                new Picture("47.95.214.19:8080/img/yunelf_stationery.png","文具"),
                new Picture("47.95.214.19:8080/img/yunelf_shop.png","金币商城")};
        return ResponseResult.Sucess ( pictures );
    }
    @GetMapping("/rochart/picture")
    public ResponseResult getRoChartPicture(){
        List<Goods> goods = goodsService.queryRoChart ();
        List<GoodsPict> goodsPicts = new ArrayList<> (  );
        for (Goods good : goods){
            goodsPicts.add ( new GoodsPict ( good.getImg_src (),good.getGoods_id (),NAVIGATOR,"/pages/goods_detail/main?goods_id="+good.getGoods_id () ) );
        }
        return ResponseResult.Sucess (goodsPicts);
    }
}
