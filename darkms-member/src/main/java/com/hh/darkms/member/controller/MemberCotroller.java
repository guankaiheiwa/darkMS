package com.hh.darkms.member.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hh.darkms.common.api.CommonResult;
import com.hh.darkms.member.entity.Member;
import com.hh.darkms.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("member")
public class MemberCotroller {
    @Autowired
    private MemberService memberService;

    /**
     * 用户登陆
     * @return
     */
    @RequestMapping("/login")
    public CommonResult login(@RequestParam("ids") Member member) {

        Wrapper wrapper = new QueryWrapper();
        Member one = memberService.getOne(wrapper);

        return CommonResult.success(null);
    }

    /**
     * 用户登陆
     * @return
     */
    @RequestMapping("/reg")
    public CommonResult reg() {
        Member member = new Member();
        member.setName("dark");
        member.setAccount("13866668888");
        member.setPassword("123456");
        member.setState(1);
        member.setRegTime(System.currentTimeMillis());
        boolean save = memberService.save(member);
        if (save){
            return CommonResult.success(member.getUid());
        }else{
            return CommonResult.failed();
        }
    }
}
