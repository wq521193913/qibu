package com.broker.domain.extend;

import com.broker.domain.CaseShow;

import java.util.List;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/4/11 0011 下午 11:16
 * @modified:
 */
public class CaseShowExt extends CaseShow{

    private List<String> sketchImgList;

    private String sketchImgs;

    public List<String> getSketchImgList() {
        return sketchImgList;
    }

    public void setSketchImgList(List<String> sketchImgList) {
        this.sketchImgList = sketchImgList;
    }

    public String getSketchImgs() {
        return sketchImgs;
    }

    public void setSketchImgs(String sketchImgs) {
        this.sketchImgs = sketchImgs;
    }
}
