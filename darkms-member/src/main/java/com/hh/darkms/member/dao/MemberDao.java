package com.hh.darkms.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.darkms.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao extends BaseMapper<Member> {
}
