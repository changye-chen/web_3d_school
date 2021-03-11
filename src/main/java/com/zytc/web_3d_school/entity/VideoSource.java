package com.zytc.web_3d_school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
/**
 * @program: web_3d_school
 * @description: 录播视频表实体类
 * @author: ChangYe-Chen
 * @create: 2021-02-18
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoSource {
    //视频id
    private int videoId;
    //视频名称
    private String name;
    //视频原片大小
    private String videoSize;
    //上传时间
    private Timestamp addTime;
    //转码状态
    private String status;
    //转码后大小
    private String videoLength;
    //视频播放码
    private String idVarchar;
    //视频时长
    private String VideoDuration;
    //封面图片地址
    private String imageUrl;
    //播放文件类型1：视频 2：音频
    private int fileType;
    //源文件类型1：视频 2：音频
    private int initType;
    //上传用户id
    private int uploadUserId;
    //视频类型
    private String videoType;
}
