//package com.crv.erais.sys.manage.controller;
//
//import com.crv.erais.model.common.Result;
//import com.crv.erais.sys.manage.common.JsonResult;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.gridfs.GridFSDBFile;
//import org.bson.types.ObjectId;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// * @author MingLi
// * @version First.0
// * @date 2019/8/29 15:52
// * 文件的上传和下载的控制类
// */
//@Controller
//@RequestMapping("/file/")
//public class MongoDBFileController {
//    private static final Logger logger = LoggerFactory.getLogger(MongoDBFileController.class);
////    @Autowired
////    private GridFsTemplate gridFsTemplate;
////    @Autowired
////    private GridFSBucket gridFSBucket;
//
//    /**
//     *获取文件的上传
//     * @param file 上传的文件
//     * @return
//     */
//    @RequestMapping("upload")
//    @ResponseBody
//    public Result uploadFile(@RequestParam("file")MultipartFile file){
//        //获得文件提交的文件名
////        String fileName=file.file
//                // 获取文件输入流
//               // InputStream ins = file.getInputStream();
//        // 获取文件类型
////        String contentType = file.getContentType();
////        // 将文件存储到mongodb中
////        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
////        logger.info("保存成功，objectId:" + objectId);
//        return Result.success();
//
//
//
//    }
//}
