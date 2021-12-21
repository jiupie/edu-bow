package com.wl.resources.web;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.wl.common.base.ResponseDTO;
import com.wl.common.exception.OSSException;
import com.wl.core.oss.core.OssTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AWS对外提供服务接口
 *
 * @author lengleng
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/oss")
@Api("OSS API")
public class OssEndpoint {

    private final OssTemplate template;


    @PostMapping("/bucket/{bucketName}")
    @ApiOperation("创建桶")
    public ResponseDTO<Bucket> createBucket(@PathVariable String bucketName) {
        template.createBucket(bucketName);
        Bucket bucket = template.getBucket(bucketName).orElseThrow(() -> new OSSException("创建桶失败"));
        return ResponseDTO.success(bucket);
    }

    @GetMapping("/bucket")
    @ApiOperation("获取所有桶")
    public ResponseDTO<List<Bucket>> getBuckets() {
        return ResponseDTO.success(template.getAllBuckets());
    }

    @ApiOperation("获取指定的桶")
    @GetMapping("/bucket/{bucketName}")
    public Bucket getBucket(@PathVariable String bucketName) {
        return template.getBucket(bucketName).orElseThrow(() -> new OSSException("没有该桶"));
    }

    @ApiOperation("删除指定的桶")
    @DeleteMapping("/bucket/{bucketName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBucket(@PathVariable String bucketName) {
        template.removeBucket(bucketName);
    }


    @ApiOperation("存储对象")
    @PostMapping(value = "/object/{bucketName}")
    public ResponseDTO<S3Object> createObject(@RequestPart @RequestParam MultipartFile file, @PathVariable String bucketName) throws Exception {
        String name = file.getOriginalFilename();
        template.putObject(bucketName, name, file.getInputStream(), file.getSize(), file.getContentType());
        return ResponseDTO.success(template.getObjectInfo(bucketName, name));
    }

    @ApiOperation("存储对象,指定对象名称")
    @PostMapping("/object/{bucketName}/{objectName}")
    public ResponseDTO<S3Object> createObject(@RequestPart @RequestParam MultipartFile object, @PathVariable String bucketName, @PathVariable String objectName) throws Exception {
        template.putObject(bucketName, objectName, object.getInputStream(), object.getSize(), object.getContentType());
        return ResponseDTO.success(template.getObjectInfo(bucketName, objectName));
    }

    @ApiOperation("获取指定对象的详细信息")
    @GetMapping("/object/detail/{bucketName}/{objectName}")
    public ResponseDTO<List<S3ObjectSummary>> filterObject(@PathVariable String bucketName, @PathVariable String objectName) {
        return ResponseDTO.success(template.getAllObjectsByPrefix(bucketName, objectName, true));
    }

    @ApiOperation("获取桶中的对象的外链，有过期时间")
    @GetMapping("/object/{bucketName}/{objectName}/{expires}")
    public ResponseDTO<Map<String, Object>> getObject(@PathVariable String bucketName, @PathVariable String objectName, @PathVariable Integer expires) {
        Map<String, Object> responseBody = new HashMap<>(8);
        responseBody.put("bucket", bucketName);
        responseBody.put("object", objectName);
        responseBody.put("url", template.getObjectURL(bucketName, objectName, expires));
        responseBody.put("expires", expires);
        return ResponseDTO.success(responseBody);
    }

    @ApiOperation("获取桶中的对象的外链，无过期时间")
    @GetMapping("/object/{bucketName}/{objectName}")
    public ResponseDTO<Map<String, Object>> getObjectPermanent(@PathVariable String bucketName, @PathVariable String objectName) {
        Map<String, Object> responseBody = new HashMap<>(8);
        responseBody.put("bucket", bucketName);
        responseBody.put("object", objectName);
        responseBody.put("url", template.getObjectURL(bucketName, objectName));
        return ResponseDTO.success(responseBody);
    }

    @ApiOperation("移除桶中的对象")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/object/{bucketName}/{objectName}/")
    public void deleteObject(@PathVariable String bucketName, @PathVariable String objectName) throws Exception {
        template.removeObject(bucketName, objectName);
    }



}
