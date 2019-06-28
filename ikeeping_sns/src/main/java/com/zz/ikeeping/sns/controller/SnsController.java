package com.zz.ikeeping.sns.controller;

import com.zz.ikeeping.common.vo.R;
import com.zz.ikeeping.entity.Comment;
import com.zz.ikeeping.entity.Community;
import com.zz.ikeeping.sns.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SnsController {

    @Autowired
    private SnsService snsService;

    @GetMapping("sns/showTopicType.do")
    public R showTopicType() {
        List<Community> list = snsService.showTopicType();
        return R.setOK("OK",list);
    }

    @GetMapping("sns/showTopicComment.do")
    public R showTopicComment(@RequestParam("uid") int uid, @RequestParam("id") int id) {
        Map<String, Object> map = snsService.showTopicComment(uid, id);
        return R.setOK("Ok", map);
    }

    @GetMapping("sns/allCommont.do")
    public R allCommont(){
        List<Comment> list = snsService.allCommont();
        return R.setOK("OK", list);
    }
}
