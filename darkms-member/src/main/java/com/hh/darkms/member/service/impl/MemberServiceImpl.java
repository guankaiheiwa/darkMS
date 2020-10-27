package com.hh.darkms.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.darkms.member.dao.MemberDao;
import com.hh.darkms.member.entity.Member;
import com.hh.darkms.member.service.MemberService;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {


}
